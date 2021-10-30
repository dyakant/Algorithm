package les3;

import java.util.ArrayDeque;
import java.util.Stack;

public class BinaryTree {
    TreeNode root;

    void insert(int data) {
        if (root == null) {
            root = new TreeNode(data);
        } else {
            insert(root, data);
        }
    }

    void insert(TreeNode node, int data) {
        if (node.data <= data) {
            if (node.right != null) {
                insert(node.right, data);
            } else {
                node.right = new TreeNode(data);
            }
        } else {
            if (node.left != null) {
                insert(node.left, data);
            } else {
                node.left = new TreeNode(data);
            }
        }
    }

    void printDeepRecursive() {
        printDeepRecursive(root);
        System.out.println("");
    }

    private void printDeepRecursive(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            printDeepRecursive(node.left);
            printDeepRecursive(node.right);
        }
    }

    void printDeep() {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.data + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        System.out.println("");
    }

    void printWide() {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        System.out.println("");
    }

    // Реализация поиска следующего элемента без параметра "Родитель" в TreeNode
    // Родитель определяется через стэк
    public int next(int val) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        // Проходим по дереву, ищем нужный элемент
        // В стэк складывается путь до ноды, т.е. его родители
        while (!(node.data == val) && !(node.right == null && node.left == null)) {
            stack.push(node);
            if (node.data > val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        // Поиск следующего, большего, значения
        int res = -1;
        while ( res < val) {
            // проверить, что есть правая нода
            // и что значение больше искомого, чтобы исключить проверку от родителя
            if (node.right != null && node.right.data > val) {
                TreeNode nextLeftNode;
                // если у правой ноды есть левые ноды, то нужно найти самую левую нода, она и будет результат
                if (node.right.left != null) {
                    nextLeftNode = checkLeftNode(node.right);
                    res = nextLeftNode.data;
                } else {
                    // если у правой ноды нет дочерней левой ноды, то правая и есть результат
                    res = node.right.data;
                }
            } else {
                // если правой ноды нет, то поднимаемся на ноду выше, к родителю
                // путь родителей лежит в стеке
                if (stack.isEmpty()) {
                    // если стек закончился, а проверки на "правую" не прошли, то это значение  самое высокое
                    res = val;
                    break;
                } else {
                    // берём родителя
                    node = stack.pop();
                    // запоминаем результат, т.к. он как раз и может быть искомым
                    res = node.data;
                }
            }
        }
        return res;
    }

    // поиск самой левой ноды
    private TreeNode checkLeftNode(TreeNode node) {
        if (node.left == null) return node;
        else return checkLeftNode(node.left);
    }

    ;
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }
}
