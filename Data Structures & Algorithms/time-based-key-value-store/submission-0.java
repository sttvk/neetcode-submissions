class TimeMap {
    Map<String, List<Pair<String, Integer>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(new Pair<>(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair<String, Integer>> list = map.get(key);
        return search(list, timestamp);
    }

    private String search(List<Pair<String, Integer>> list, int timestamp) {
        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (list.get(mid).getValue() <= timestamp) {
                if (mid == list.size() - 1 || list.get(mid + 1).getValue() > timestamp) {
                    return list.get(mid).getKey();
                }
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return "";
    }
}
