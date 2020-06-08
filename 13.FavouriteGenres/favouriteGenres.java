import java.util.*;

class Playground {
    public static void main(String[ ] args) {
        Map<String, List<String>> userSongs = new HashMap<>();
        Map<String, List<String>> songGenres = new HashMap<>();
        Map<String, Map<String, Integer>> userGenres = new HashMap<>();
        Map<String, Integer> userMax = new HashMap<>();
        Map<String, List<String>> res = new HashMap<>();
        Map<String, String> songGenreMap = new HashMap<>();

        userSongs.put("David", Arrays.asList(new String[]{"song1", "song2", "song3", "song4", "song8"}));
        userSongs.put("Emma", Arrays.asList(new String[]{"song5", "song6", "song7"}));
        
        songGenres.put("Rock", Arrays.asList(new String[]{"song1", "song3"}));
        songGenres.put("Dubstep", Arrays.asList(new String[]{"song7"}));
        songGenres.put("Techno", Arrays.asList(new String[]{"song2", "song4"}));
        songGenres.put("Pop", Arrays.asList(new String[]{"song5", "song6"}));
        songGenres.put("Jazz", Arrays.asList(new String[]{"song8", "song9"}));
        
        // time & space complexity is total # of songs s.
        for(String key: songGenres.keySet())
            for(String song: songGenres.get(key))
                songGenreMap.put(song, key);
            
        
        // time complexity is total # of users * songs. while space is total # of users * genres
        for(String key: userSongs.keySet()) {
            Map<String, Integer> genreCount = new HashMap<>();
            for(String song: userSongs.get(key)) {
                if(songGenreMap.get(song) != null) {
                    String genre = songGenreMap.get(song);
                    int count = genreCount.getOrDefault(genre, 0) + 1;
                    
                    // build a user map of genre count map, i.e for each user we maintain a map of genre's & it's count
                    genreCount.put(genre, count);
                    userMax.put(key, Math.max(userMax.getOrDefault(key, 0), count));
                }
            }
            userGenres.put(key, genreCount);
        }
        
        // populates results in the desired format, time & space is users * genres
        for(String key: userGenres.keySet()) {
         List<String> genres = new ArrayList<>();
         for(String genre: userGenres.get(key).keySet()) {
             if(userGenres.get(key).get(genre) == userMax.get(key)) 
                genres.add(genre);
         }
         res.put(key, genres);
        }
        
        // time is total number of users.
        for(String key: res.keySet())
            System.out.println(key+": "+res.get(key));
    }
}


// Output: {  
//   "David": ["Rock", "Techno"],
//   "Emma":  ["Pop"]
// }
