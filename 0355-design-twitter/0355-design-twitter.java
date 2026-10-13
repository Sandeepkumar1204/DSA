
import java.util.*;

class Twitter {

    private static class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    private Map<Integer, List<Tweet>> tweets;
    private Map<Integer, Set<Integer>> following;
    private int time;

    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq =
            new PriorityQueue<>((a, b) -> b.time - a.time);

       
        addTweets(pq, userId);

        
        Set<Integer> users = following.getOrDefault(
            userId, new HashSet<>());

        for (int followeeId : users) {
            addTweets(pq, followeeId);
        }

        List<Integer> feed = new ArrayList<>();

        while (!pq.isEmpty() && feed.size() < 10) {
            feed.add(pq.poll().tweetId);
        }

        return feed;
    }

    private void addTweets(PriorityQueue<Tweet> pq, int userId) {
        List<Tweet> list = tweets.get(userId);

        if (list == null) return;

        for (Tweet tweet : list) {
            pq.offer(tweet);
        }
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}