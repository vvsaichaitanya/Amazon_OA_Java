class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        if (products == null || searchWord == null || searchWord.isEmpty()) {
            return result;
        }

        Arrays.sort(products);
        StringBuilder prefix = new StringBuilder();

        String prefStr;
        int start = 0;
        int end = products.length;
        int curr;
        int max = 3;
        int num;
        for (int i = 0; i < searchWord.length(); i++) {
            prefix.append(searchWord.charAt(i));
            prefStr = prefix.toString();
            while (start < end && !products[start].startsWith(prefStr)) {
                start++;
            }

            curr = start;
            List<String> list = new ArrayList<>();
            num = 0;
            while (curr < end && products[curr].startsWith(prefStr) && num < max) {
                list.add(products[curr++]);
                num++;
            }
            result.add(list);
        }
        return result;
    }
}