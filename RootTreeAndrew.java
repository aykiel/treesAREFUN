public class RootTreeAndrew<E extends Comparable<E>>
{
    Node root;

    protected class Node
    {
        public E e;
        public Node left;
        public Node right;

        Node(E e)
        {
            this.e = e;
            left = null;
            right = null;
        }

        public E getE() {
            return e;
        }
    }


    public void add(E e)
    {
        root = addRecursive(root, e);
    }

    public void delete(E e)
    {
        root = deleteRecursive(root, e);
    }


    public Node addRecursive(Node current, E e)
    {
        if (current == null)
        {
            return new Node(e);
        }

        if (e.compareTo(current.getE()) > 0)
        {
            current.left = addRecursive(current.left, e);
        }
        else if (e.compareTo(current.getE()) < 0)
        {
            current.right = addRecursive(current.right, e);
        }

        return current;
    }

    private Node deleteRecursive(Node current, E e)
    {
        if (current == null)
        {
            return null;
        }

        //delete
        if (e == current.e)
        {
            //if they're both empty
            if (current.left == null && current.right == null)
            {
                return null;
            }

            //right is empty
            if (current.right == null)
            {
                return current.left;
            }

            //left empty
            if (current.left == null)
            {
                return current.right;
            }

            E samller = smallerNode(current.right);
            current.e = samller;
            current.right = deleteRecursive(current.right, samller);
            return current;
        }

        if (e.compareTo(current.e) < 0)
        {
            //delete left if it is greater
            current.left = deleteRecursive(current.left, e);
            return current;
        }

        //runs if nothing else is true
        current.right = deleteRecursive(current.right, e);
        return current;
    }



    private E smallerNode(Node root)
    {
        if (root.left == null)
        {
            return root.e;
        }
        else
        {
            return smallerNode(root.left);
        }
    }

    public void traverseInOrder(Node node)
    {
        if (node != null)
        {
            traverseInOrder(node.left);
            System.out.print(" " + node.e);
            traverseInOrder(node.right);
        }
    }

    public void traversePreOrder(Node node)
    {
        if (node != null)
        {
            System.out.print(" " + node.e);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traversePostOrder(Node node)
    {
        if (node != null)
        {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.e);
        }
    }
}
