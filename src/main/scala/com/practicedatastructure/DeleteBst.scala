package com.practicedatastructure

object DeleteBst {

  // Data structure to store a Binary Search Tree node
  class Node(var data: Int) {
    var left: Node = null
    var right: Node = null
  }

//  object test3 { // Function to perform inorder traversal of the test3
    def inorder(root: Node): Unit = {
      if (root == null) return
      inorder(root.left)
      System.out.print(root.data + " ")
      inorder(root.right)
    }

    // Helper function to find minimum value node in subtree rooted at curr
    def minimumKey(curr: Node): Node = {
      var max:Node = curr
      while ( {
        max.left != null
      }) max = max.left
      max
    }
  def maximumKey(curr: Node): Node = {
    var max:Node = curr
    while ( {
      max.right != null
    }) max = max.left
    max
  }

    // Recursive function to insert a key into test3
    def insert(root: Node, key: Int): DeleteBst.Node = { // if the root is null, create a new node and return it
      if (root == null)
        return new Node(key)
      if (key <= root.data) {
        root.left = insert(root.left, key)
      }
      else {
        root.right = insert(root.right, key)
      }
      root
    }

    // Function to delete node from a test3
    def deleteNode(root: Node, key: Int): Node = {
      // pointer to store parent node of current node
      var parent: Node = null
      // start with root node
      var curr = root
      while (curr != null && curr.data != null) {
        parent = curr
        if (key < curr.data) {
          curr = curr.left
        }
        else {
          curr = curr.right
        }
      }
      // return if key is not found in the tree
      if (curr == null) return root
      // Case 1: node to be deleted has no children i.e. it is a leaf node

      if (curr.left == null && curr.right == null) { // if node to be deleted is not a root node, then set its
        // parent left/right child to null
        if (curr != root) {
          if (parent.left == curr)
            parent.left = null
          else parent.right = null
        }

        // if tree has only root node, delete it and set root to null
      else root = null
    }
      // Case 2: node to be deleted has two children
      else if (curr.left != null && curr.right != null){
        var successor = minimumKey(curr.right)
        // store successor value
        var successor_data = successor.data
        // recursively delete the successor. Note that the successor
        // will have at-most one child (right child)
        deleteNode(root, successor.data)
        curr.data = successor_data
      }
      // Case 3: node to be deleted has only one child
      else {
        var child = if (curr.left != null) curr.left
        else curr.right
        // if node to be deleted is not a root node, then set its parent
        // to its child
        if (curr ne root) {
          if (curr eq parent.left) parent.left = child
          else parent.right = child
        }
        else{ root = child
      }
      return root
    }

    // main function
    def main(args: Array[String]): Unit = {
      var root:Node = null
      var keys = Array(15, 10, 20, 8, 12, 16)
      for (key <- keys) {
        root = insert(root, key)
      }
      root = deleteNode(root, 16)
      inorder(root)
    }
  }


