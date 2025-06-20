package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {

    int feedMaxNum; // maximum number of tweets in the feed
    int time; // timestamp

    Map<Integer, List<Tweet>> tweetMap;    // userId -> List of tweets
    Map<Integer, Set<Integer>> followMap; // userId -> Set of followeeIds

    /**
     * Pair class to hold tweet ID and timestamp.
     */
    static class Tweet {
        int id;
        int time;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    /**
     * Initialize Twitter.
     */
    public Twitter() {
        time = 0;
        feedMaxNum = 10;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     *
     * @param userId  the user ID of the tweet author
     * @param tweetId the tweet ID
     */
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k ->
                new ArrayList<>()).add(new Tweet(tweetId, time++));
    }

    /**
     * Retrieve the 10 most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by
     * users who the user followed or by the user themselves. Tweets must be ordered from most recent to least recent.
     *
     * @param userId the user ID
     * @return a list of tweet IDs
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> tweets = new ArrayList<>();
        Set<Integer> followees = followMap.getOrDefault(userId, new HashSet<>());
        followees.add(userId);

        for (int followeeId : followees) {
            List<Tweet> userTweets = tweetMap.getOrDefault(followeeId, new ArrayList<>());
            tweets.addAll(userTweets);
        }

        tweets.sort((a, b) -> Integer.compare(b.time, a.time));
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < Math.min(10, tweets.size()); i++) {
            result.add(tweets.get(i).id);
        }
        return result;
    }

    /**
     * Retrieve the 10 most recent tweet IDs in the user's news feed using a max heap.
     * Each item in the news feed must be posted by users who the user followed or by the user themselves.
     * Tweets must be ordered from most recent to least recent.
     *
     * @param userId the user ID
     * @return a list of tweet IDs
     */
    public List<Integer> getNewsFeedWithHeap(int userId) {
        PriorityQueue<Tweet> feed = new PriorityQueue<>((a, b) -> b.time - a.time);

        Set<Integer> followees = followMap.getOrDefault(userId, new HashSet<>());
        followees.add(userId);

        for (int followeeId : followees) {
            List<Tweet> userTweets = tweetMap.getOrDefault(followeeId, new ArrayList<>());
            for (Tweet tweet : userTweets) {
                feed.offer(tweet);
            }
        }

        List<Integer> result = new ArrayList<>();
        int count = 0;

        while (!feed.isEmpty() && count < feedMaxNum) {
            result.add(feed.poll().id);
            count++;
        }
        return result;
    }

    /**
     * Follow a user.
     *
     * @param followerId the user ID of the follower
     * @param followeeId the user ID of the user to be followed
     */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        followMap.computeIfAbsent(followerId, k ->
                new HashSet<>()).add(followeeId);
    }

    /**
     * Unfollow a user.
     *
     * @param followerId the user ID of the follower
     * @param followeeId the user ID of the user to be unfollowed
     */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1)); // [5]
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1)); // [6, 5]
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1)); // [5]
    }

}
