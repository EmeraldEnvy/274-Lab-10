public class BST {
    /**
     * Node class
     */
    private static class Node {
        /**
         * Initialize data
         */
        private Word data;
        /**
         * Initialize left
         */
        private Node left;
        /**
         * Initialize right
         */
        private Node right;

        /**
         * Construct node
         * @param d
         */
        public Node( Word d ) {
            data = d;
            left = null;
            right = null;
        }

        /**
         * Node to string
         * @return string
         */
        public String toString( ) {
            return " " + data;
        }
    }

    /**
     * Initialize root
     */
    private Node root;

    /**
     * Construct binary search tree
     */
    public BST( ) {
        root = null;
    }

    /**
     * Search tree for particular value
     * @param d word
     * @return word
     */
    public Word contains( Word d ) {
        Word nothing = new Word( "" );
        if ( root == null ) {
            return nothing;
        } else {
            return contains( d, root );
        }
    }

    /**
     * Facade for contains
     * @param d word
     * @param n node
     * @return word
     */
    private Word contains( Word d, Node n ) {
        if ( d.compareTo( n.data ) == 0 ) {
            return n.data;
        }
        if ( d.compareTo( n.data ) < 0 ) {
            if ( n.left == null ) {
                return null;
            } else {
                return contains( d, n.left );
            }
        } else {
            if ( n.right == null ) {
                return null;
            } else {
                return contains( d, n.right );
            }
        }
    }

    /**
     * In order traversal
     * @return tree as sorted string
     */
    public String toSortedString( ) {
        return toSortedString( root );
    }

    /**
     * Facade of toSortedString
     * @param n node
     * @return string
     */
    private String toSortedString( Node n ) {
        String s = "";
        if ( n != null ) {
            s += toSortedString( n.left );
            s += n.data + "\n";
            s += toSortedString( n.right );
        }
        return s;
    }

    /**
     * Post order string
     * @return string in post order
     */
    public String toPostOrderString( ) {
        return toPostOrderString( root );
    }
    /**
     * Facade of toPostOrderString
     * @param n node
     * @return string
     */
    private String toPostOrderString( Node n ) {
        String s ="";
        if ( n != null ) {
            s += toPostOrderString( n.left );
            s += toPostOrderString( n.right );
            s += n.data + " ";
        }
        return s;
    }

    /**
     * Pre order traversal
     * Size
     * @return size
     */
    public int size( ) {
        return size( root );
    }

    /**
     * Facade of size
     * @param n node
     * @return size count
     */
    private int size( Node n ) {
        int count = 0;
        if ( n != null ) {
            count = 1;
            count += size( n.left );
            count += size( n.right );
        }
        return count;
    }

    /**
     * Checks if tree is empty
     * @return true if empty
     */
    public boolean isEmpty( ) {
        return root == null;
    }

    /**
     * Add word to BST
     * @param d word
     */
    public void add( Word d ) {
        d.incFrequency();
        root = add( d, root );
    }

    /**
     * Facade of add
     * @param d word
     * @param n node
     * @return word
     */
    private Node add( Word d, Node n ) {
        if( n == null ) {
            return new Node( d );
        } else {
            if( d.compareTo( n.data ) < 0) {
                n.left = add( d, n.left );
            }
            else{
                if( d.compareTo(n.data) == 0 ){
                    //Increments frequency
                    d = n.data;
                    d.incFrequency();
                    return n;

                }
                n.right = add( d, n.right );
            }
            return n;
        }
    }

    /**
     * Print tree
     */
    public void printBST( ) {
        if( isEmpty( ) ) {
            System.out.println( "Tree is empty." );
        } else {
            printBST( root );
        }
    }

    /**
     * Facade of printBST
     * @param n node
     */
    private void printBST( Node n ) {
        //go down left tree
        if ( n.left != null ) {
            printBST( n.left );
        }
        //go down right tree
        System.out.print( n.data + "\n" );
        if( n.right != null ) {
            printBST( n.right );
        }
    }
}
