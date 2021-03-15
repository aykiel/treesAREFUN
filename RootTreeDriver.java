public class RootTreeDriver
{
    public static void main (String[] args)
    {
        RootTreeAndrew<Integer> bt = new RootTreeAndrew();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        bt.traverseInOrder(bt.root);

        bt.delete(6);

        System.out.println();
        bt.traverseInOrder(bt.root);

        bt.add(11);
        System.out.println();
        bt.traverseInOrder(bt.root);

        System.out.println();
        bt.traversePostOrder(bt.root);

        System.out.println();
        bt.traversePreOrder(bt.root);
    }
}
