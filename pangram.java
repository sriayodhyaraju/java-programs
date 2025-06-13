class Main {
    public boolean checkifpangram(String sentence) {
        if (sentence.length() < 26) return false;

        boolean[] seen = new boolean[26];

        for (char c : sentence.toCharArray()) {
            if (Character.isLowerCase(c)) {
                seen[c - 'a'] = true;
            }
        }

        // Check if all 26 letters were seen
        for (boolean b : seen) {
            if (!b) return false;
        }

        return true;
    }
}