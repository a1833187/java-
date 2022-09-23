package qrxedu.lcseries.leedcode355;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近 10 条推文。
 * <p>
 * 实现 Twitter 类：
 * <p>
 * Twitter() 初始化简易版推特对象
 * void postTweet(int userId, int tweetId) 根据给定的 tweetId 和 userId 创建一条新推文。每次调用次函数都会使用一个不同的 tweetId 。
 * List<Integer> getNewsFeed(int userId) 检索当前用户新闻推送中最近10 条推文的 ID 。
 * 新闻推送中的每一项都必须是由用户关注的人或者是用户自己发布的推文。推文必须 按照时间顺序由最近到最远排序 。
 * void follow(int followerId, int followeeId) ID 为 followerId 的用户开始关注 ID 为 followeeId 的用户。
 * void unfollow(int followerId, int followeeId) ID 为 followerId 的用户不再关注 ID 为 followeeId 的用户。
 */
public class Twitter {
class Node {
    public int userId;
    public List<Integer> follist = new ArrayList<>();
    public List<Integer> myList = new ArrayList<>();
    public Node next;

    public Node(int userId) {
        this.userId = userId;
    }
}

    public Node head;

    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        Node n = new Node(userId);
        Node cur = head;
        if (head == null) {
            head = n;
            //head.follist.add(0, userId);
            //head.myList.add(0, tweetId);
        }else{
            while(cur!= null){
                if(cur.userId == userId){
                    break;
                }
                if(cur.next == null){
                    //n.follist.add(0, userId);
                    //n.myList.add(0, tweetId);
                    n.next = head;
                    head = n;
                }
                cur = cur.next;
            }
        }
        cur = head;
        while (cur != null) {
            if (cur.userId == userId) {
                int i;
                for(i = 0; i < cur.follist.size();i++){
                    if(cur.follist.get(i)==userId){
                        break;
                    }
                }
                if(i == cur.follist.size()){
                    cur.follist.add(0,userId);
                }
                cur.myList.add(0, tweetId);
                return;
            }
            cur = cur.next;
        }

    }

    public List<Integer> getNewsFeed(int userId) {
        Node cur = head;
        List<Integer> dList = new ArrayList<>();
        while (cur != null) {
            if (cur.userId == userId) {
                break;
            }
            cur = cur.next;
        }
        if(cur == null){
            return dList;
        }
        for(int i = cur.follist.size()-1; i >= 0; i--){
            Node tmp = head;
            while(tmp != null){
                if(tmp.userId == cur.follist.get(i)){
                    dList.addAll(0,tmp.myList);
                }
                tmp = tmp.next;
            }
        }
        if(dList.size()<=10) {
            return dList;
        }else{
            return dList.subList(0,10);
        }
    }

    public void follow(int followerId, int followeeId) {
        //cur为被关注者,tmp为关注者
        Node tmp = head;
        Node cur = head;
        while(tmp!= null){
            if(tmp.userId == followerId){
                break;
            }
            tmp = tmp.next;
        }
        while(cur!= null){
            if(cur.userId == followeeId){
                break;
            }
            cur = cur.next;
        }
        if(tmp==null){
            tmp = new Node(followerId);
            if (head == null) {
                head = tmp;
                //head.follist.add(0,followerId);
                //return;
            }else{
                //tmp.follist.add(0, followerId);
                tmp.next = head;
                head = tmp;
            }
        }
        if(cur==null){
            cur  = new Node(followeeId);
            if (head == null) {
                head = cur;
                // head.follist.add(0,followeeId);
                //return;
            }else{
                //cur.follist.add(0, followeeId);
                cur.next = head;
                head = cur;
            }
        }
        for(int i = 0; i  < tmp.follist.size();i++){
            if(tmp.follist.get(i) == followeeId){
                return;
            }
        }
        tmp.follist.add(0,followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        //cur为被关注者,tmp为关注者
        Node tmp = head;
        if (head == null) {
            return;
        }
        while(tmp!= null){
            if(tmp.userId == followerId){
                break;
            }
            tmp = tmp.next;
        }
        if(tmp==null){
            return;
        }
        tmp.follist.remove((Object)followeeId);
    }
}