import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: AncientAnton
 * Date: 2020/4/18
 * Description:
 */

public class DesignTwitter {
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
    public DesignTwitter() {
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
}
