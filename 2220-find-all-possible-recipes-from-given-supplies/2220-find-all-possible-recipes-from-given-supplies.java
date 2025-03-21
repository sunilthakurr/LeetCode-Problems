class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        boolean isAnotherRoundRequired = true;
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(String supply: supplies) {
            set.add(supply);
        }
        while(isAnotherRoundRequired) {
            isAnotherRoundRequired = false;
        
            for(int i = 0; i < recipes.length; i++) {
                boolean flag = true;
                if(!recipes[i].equals("-1")) {
                    for(String ingredient: ingredients.get(i)) {
                        if(!set.contains(ingredient)) {
                            flag = false;
                            break;
                        }
                    }   
                    if(flag) {
                        set.add(recipes[i]);
                        res.add(recipes[i]);
                        recipes[i] = "-1";
                        isAnotherRoundRequired = true;
                    }
                }
            }
            }
        
        return res;
    }
}