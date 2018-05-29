import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        for (int i = 0; i < intervals.size()-1; i++) {
            for (int j = i+1; j < intervals.size(); j++) {
                Interval temp = helper(intervals.get(i), intervals.get(j));
                if (temp != null) {
                    intervals.set(j, temp);
                    intervals.set(i, null);
                    break;
                }
            }
        }
        List<Interval> result = new ArrayList<>();
        for (Interval in:intervals) {
            if (in != null) result.add(in);
        }
        return result;
    }
    private Interval helper(Interval x, Interval y) {
        if (x.end >= y.start && x.end <= y.end && x.start <= y.start) return new Interval(x.start, y.end);
        else if (x.start >= y.start && x.start <= y.end && x.end >= y.end) return new Interval(y.start, x.end);
        else if (x.start <= y.start && x.end >= y.end) return x;
        else if (x.start >= y.start && x.end <= y.end) return y;
        else return null;
    }
}