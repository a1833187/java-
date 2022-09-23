package qrxedu.btree;

/**
 * @author qiu
 * @version 1.8.0
 */
public class BTree {
    public static final int M = 3;

    static class BNode {
        //这个keys也可以是一个Pair<K,V>[]
        public int[] keys;
        public BNode[] subs;
        public BNode parent;
        public int usedSize;

        public BNode() {
            this.keys = new int[M];
            this.subs = new BNode[M + 1];
        }
    }

    public BNode root;

    public boolean insert(int key) {
        if (root == null) {
            root = new BNode();
            root.keys[0] = key;
            root.usedSize++;
            return true;
        }
        Pair<BNode, Integer> pair = find(key);
        if (pair.getVal() != -1) {
            return false;
        }

        BNode parent = pair.getKey();
        int idx = parent.usedSize - 1;
        for (; idx >= 0; idx--) {
            if (parent.keys[idx] > key) {
                parent.keys[idx + 1] = parent.keys[idx];
            } else {
                break;
            }
        }
        parent.keys[idx + 1] = key;
        parent.usedSize++;

        if (parent.usedSize >= M) {
            split(parent);
        } else {
            return true;
        }
        return false;

    }

    private void split(BNode parent) {
        BNode node = new BNode();
        BNode pp = parent.parent;
        int mid = parent.usedSize >> 1;
        int midVal = parent.keys[mid];
        int j = 0;
        int i = mid + 1;
        for (; i < parent.usedSize; i++) {
            node.keys[j] = parent.keys[i];
            node.subs[j] = parent.subs[i];
            parent.keys[i] = 0;
            parent.subs[i] = null;
            if (node.subs[j] != null) {
                node.subs[j].parent = node;
            }
            j++;
        }
        node.subs[j] = parent.subs[i];
        parent.subs[i] = null;
        parent.keys[mid] = 0;
        if (node.subs[j] != null) {
            node.subs[j].parent = node;
        }

        node.usedSize = j;
        parent.usedSize = parent.usedSize - j - 1;

        if (pp == null) {
            root = new BNode();
            root.keys[0] = midVal;
            root.subs[1] = node;
            root.subs[0] = parent;
            root.usedSize = 1;
            parent.parent = root;
            node.parent = root;
        } else {
            node.parent = pp;

            int entT = pp.usedSize - 1;

            for (; entT >= 0; entT--) {
                if (pp.keys[entT] > midVal) {
                    pp.keys[entT + 1] = pp.keys[entT];
                    pp.subs[entT + 2] = pp.subs[entT + 1];
                } else {
                    break;
                }
            }
            pp.keys[entT + 1] = midVal;
            pp.subs[entT + 2] = node;
            pp.usedSize++;
            if (pp.usedSize >= M) {
                split(pp);
            }
        }

    }

    public boolean remove(int key) {
        Pair<BNode, Integer> replaced = find(key);
        Pair<BNode, Integer> removed = getNextNode(replaced);
        BNode replace = replaced.getKey();
        BNode remove = removed.getKey();
        if (replace == null || remove == null) {
            return false;
        }
        if (replace.keys[replaced.getVal()] != remove.keys[0]) {
            replace.keys[replaced.getVal()] = remove.keys[0];
        }
        for (int i = removed.getVal(); i < remove.usedSize - 1; i++) {
            remove.keys[i] = remove.keys[i + 1];
        }
        remove.keys[remove.usedSize - 1] = 0;
        remove.usedSize--;
        removeLeaf(remove.parent, removed.getVal(), 0, replace);
        return true;
    }

    private void removeLeaf(BNode p, int target, int index, BNode t) {
        if (p == t) {
            index = target;
        }
        int max = M / 2 - 1;
        BNode sub = p.subs[index];
        BNode subL = index - 1 >= 0 ? p.subs[index - 1] : null;
        BNode subR = index + 1 < M ? p.subs[index + 1] : null;
        if (index == 0) {
            if (sub.usedSize <= max) {
                if (subR != null && subR.usedSize > max) {
                    int subRKey = subR.keys[0];
                    int pKey = p.keys[0];
                    p.keys[0] = subRKey;
                    BNode child = subR.subs[0];
                    for (int i = 0; i < subR.usedSize - 1; i++) {
                        subR.keys[i] = subR.keys[i + 1];
                        subR.subs[i] = subR.subs[i + 1];
                    }
                    subR.keys[subR.usedSize - 1] = 0;
                    subR.subs[subR.usedSize - 1] = subR.subs[subR.usedSize];
                    subR.subs[subR.usedSize] = null;
                    sub.keys[sub.usedSize] = pKey;
                    sub.subs[sub.usedSize + 1] = child;
                    sub.usedSize++;
                    subR.usedSize--;
                } else {
                    // 将父亲节点的key移动到右兄弟
                    int pKey = p.keys[0];

                    if (subR != null) {
                        // 将右兄弟节点中的key和child向后移动一位
                        for (int i = subR.usedSize - 1; i >= 0; i--) {
                            subR.keys[i + 1] = subR.keys[i];
                            subR.subs[i + 2] = subR.subs[i + 1];
                        }

                        // 将父亲key插入到右兄弟的头key并更新容量
                        subR.keys[0] = pKey;
                        subR.usedSize++;
                        //将待删除节点的所有key和child移动到右兄弟的头结点
                        subR.usedSize += sub.usedSize;

                        for (int i = subR.usedSize - 1; i >= 0; i--) {
                            subR.keys[i + 1] = subR.keys[i];
                            subR.subs[i + 2] = subR.subs[i + 1];
                        }
                        for (int i = 0; i < sub.usedSize; i++) {
                            subR.keys[i] = sub.keys[i];
                            subR.subs[i] = sub.subs[i];
                        }
                        subR.subs[sub.usedSize] = sub.subs[sub.usedSize];
                        // 将父亲节点的后面节点向后移动1位

                        for (int i = 0; i < p.usedSize; i++) {
                            p.keys[i] = p.keys[i + 1];
                            p.subs[i + 1] = p.subs[i + 2];
                        }
                        p.keys[p.usedSize - 1] = 0;
                        p.subs[p.usedSize] = null;
                        p.usedSize--;
                    }
                    removeLeaf(p.parent, target, index, t);
                }
            }
        } else {
            if (subL != null && subL.usedSize > max) {
                int subLKey = subL.keys[subL.usedSize - 1];
                BNode child = subL.subs[subL.usedSize];
                subL.keys[subL.usedSize - 1] = 0;
                subL.subs[subL.usedSize] = null;
                int pKey = p.keys[index - 1];
                p.keys[index - 1] = subLKey;
                for (int i = sub.usedSize - 1; i >= 0; i--) {
                    sub.keys[i + 1] = sub.keys[i];
                    sub.subs[i + 2] = sub.subs[i + 1];
                }
                sub.subs[1] = sub.subs[0];
                sub.keys[0] = subLKey;
                sub.subs[0] = child;
                subL.usedSize--;
                sub.usedSize++;
            } else if (subR != null && subR.usedSize > max) {
                int subRKey = subR.keys[0];
                int pKey = p.keys[index - 1];
                p.keys[index - 1] = subRKey;
                BNode child = subR.subs[0];
                for (int i = 0; i < subR.usedSize - 1; i++) {
                    subR.keys[i] = subR.keys[i + 1];
                    subR.subs[i] = subR.subs[i + 1];
                }
                subR.keys[subR.usedSize - 1] = 0;
                subR.subs[subR.usedSize - 1] = subR.subs[subR.usedSize];
                subR.subs[subR.usedSize] = null;
                sub.keys[sub.usedSize] = pKey;
                sub.subs[sub.usedSize + 1] = child;
                sub.usedSize++;
                subR.usedSize--;
            } else {
               // 这里就是将该节点以及连接该节点的父亲节点的key值全部转移到左兄弟或右兄弟上,然后继续递归
                int pKey = p.keys[index - 1];
                if (subL != null) {
                    subL.keys[subL.usedSize] = pKey;
                    subL.usedSize++;

                } else if (subR != null) {

                }

            }
        }

    }

    private Pair<BNode, Integer> getNextNode(Pair<BNode, Integer> p) {
        BNode cur = p.getKey();
        if (cur == null) {
            return new Pair<>(null, -1);
        }
        int index = p.getVal();
        BNode child = cur.subs[index + 1];
        if (child == null) {
            // 待删除节点是叶子节点
            return new Pair<>(cur, index);
        }
        while (child != null) {
            cur = child;
            child = cur.subs[0];
        }
        // index返回的是叶子节点在key数组中的位置
        return new Pair<>(cur, index + 1);
    }

    private Pair<BNode, Integer> find(int key) {

        BNode cur = root;
        BNode parent = null;
        while (cur != null) {
            int i = 0;
            while (i < cur.usedSize) {
                if (cur.keys[i] == key) {
                    return new Pair<>(cur, i);
                } else if (cur.keys[i] < key) {
                    i++;
                } else {
                    break;
                }
            }
            parent = cur;
            cur = cur.subs[i];
            //cur.parent = parent;
        }
        return new Pair<>(parent, -1);
    }

    /**
     * 类似于二叉树的中序遍历:原理是先输出root.subs[i],然后在输出root.keys[i],依据B-树的一个性质:keys[i]和key[i+1]之间的孩子的值的大小介于两者之间
     *
     * @param root
     */
    private void inOrder(BNode root) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < root.usedSize; i++) {
            inOrder(root.subs[i]);
            System.out.println(root.keys[i]);
        }
        inOrder(root.subs[root.usedSize]);
    }

    public static void main(String[] args) {
        int[] arr = {53, 139, 75, 49, 145, 36, 101};
        BTree t = new BTree();
        for (int i = 0; i < arr.length; i++) {
            t.insert(arr[i]);
        }
        t.inOrder(t.root);
    }
}
