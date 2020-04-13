import java.util.*;

/**
 * Author: AncientAnton
 * Date: 2020/4/5
 * Description:
 */

public class Twitter {

    private HashMap<Integer, Tweet> userTweetsMap = new HashMap<>();
    private HashMap<Integer, List<Integer>> followeesMap = new HashMap<>();
    private static int ID_GENERATOR;

    private static class Tweet {
        int tweetId;
        int order;
        Tweet next;

        public Tweet(int tweetId) {
            this.tweetId = tweetId;
            this.order = ID_GENERATOR++;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
    }

    private List<Integer> getFollowees(int userId) {
        List<Integer> followees = followeesMap.get(userId);
        if (followees == null) {
            followees = new LinkedList<>();
            followeesMap.put(userId, followees);
        }
        return followees;
    }


    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId);
        tweet.next = userTweetsMap.get(userId);
        userTweetsMap.put(userId, tweet);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> followees = getFollowees(userId);
        List<Tweet> tweets = new ArrayList<>();
        for (Integer followee : followees) {
            Tweet tweet = userTweetsMap.get(followee);
            if (tweet != null) {
                Tweet temp = tweet;
                tweets.add(temp);
            }
        }
        if (userTweetsMap.get(userId) != null) {
            tweets.add(userTweetsMap.get(userId));
        }
        return getTopTen(tweets);
    }


    private List<Integer> getTopTen(List<Tweet> tweets) {
        List<Integer> result = new LinkedList<>();
        while (result.size() < 10) {
            int cur = -1;
            int max = -1;
            for (int i = 0; i < tweets.size(); ++i) {
                if (tweets.get(i).order > max) {
                    max = tweets.get(i).order;
                    cur = i;
                }
            }
            if (cur == -1) {
                break;
            } else {
                Tweet temp = tweets.get(cur);
                result.add(temp.tweetId);
                tweets.remove(cur);
                if (temp.next != null) {
                    tweets.add(cur, temp.next);
                }
            }
        }
        return result;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        int index = getFollowees(followerId).indexOf(followeeId);
        if (index == -1) {
            getFollowees(followerId).add(followeeId);
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        int index = getFollowees(followerId).indexOf(followeeId);
        if (index != -1) {
            getFollowees(followerId).remove(index);
        }
    }

    private static void print(List<Integer> list) {
        System.out.print('[');
        if ( !list.isEmpty()) {
            System.out.print(list.get(0));
            for (int i = 1; i < list.size(); ++i) {
                System.out.print(',');
                System.out.print(list.get(i));
            }
        }
        System.out.println(']');
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        String[] commands = new String[]{"Twitter","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed","follow","getNewsFeed"};
        int[][] options = new int[][]{new int[]{},new int[]{2,5},new int[]{1,3},new int[]{1,101},new int[]{2,13},new int[]{2,10},new int[]{1,2},new int[]{2,94},new int[]{2,505},new int[]{1,333},new int[]{1,22},new int[]{2},new int[]{2,1},new int[]{2}};
        for (int i = 0; i < commands.length; ++i) {
            switch (commands[i]) {
                case "Twitter":
                    break;
                case "postTweet":
                    twitter.postTweet(options[i][0], options[i][1]);
                    break;
                case "getNewsFeed":
                    print(twitter.getNewsFeed(options[i][0]));
                    break;
                case "follow":
                    twitter.follow(options[i][0], options[i][1]);
                    break;
                case "unfollow":
                    twitter.unfollow(options[i][0], options[i][1]);
                    break;
            }
        }
    }
}
