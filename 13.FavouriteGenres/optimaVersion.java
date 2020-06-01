import java.util.*;

class Playground {
    public static void main(String[ ] args) {
        Map<String, List<String>> userSongs = new HashMap<>();
        Map<String, List<String>> songGenres = new HashMap<>();
        Map<String, List<String>> userGenres = new HashMap<>();
        Map<String, Integer> userMax = new HashMap<>();
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
            
        
        // time complexity is total # of user * (songs+genres). while space is total # of genres
        for(String key: userSongs.keySet()) {
            Map<String, Integer> genreCount = new HashMap<>();
            List<String> genres = new ArrayList<>();
            int max = Integer.MIN_VALUE;
            
            for(String song: userSongs.get(key)) {
                if(songGenreMap.get(song) != null) {
                    String genre = songGenreMap.get(song);
                    int count = genreCount.getOrDefault(genre, 0) + 1;
                    
                    // build a user map of genre count map, i.e for each user we maintain a map of genre's & it's count
                    genreCount.put(genre, count);
                    max = Math.max(max, count);
                }
            }
            
            for(String genre: genreCount.keySet()){
                if(genreCount.get(genre) == max)
                    genres.add(genre);
            }
            userGenres.put(key, genres);
        }
        
    
        
        for(String key: userGenres.keySet())
            System.out.println(key + ": " + userGenres.get(key));
    }
}


// Output: {  
//   "David": ["Rock", "Techno"],
//   "Emma":  ["Pop"]
// }
