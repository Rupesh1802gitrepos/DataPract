package com.practicedatastructure

import java.util
import java.util.concurrent.atomic.AtomicInteger

import scala.collection.mutable

object BSTFromPostorderAndPreorderSequence {
  class Node(var data: Int) {
        var left: Node = null
        var right: Node = null
      }
  def inOrder(root:Node): Unit ={
    if(root==null)
      return root
    inOrder(root.left)
    print(root.data+" ")
    inOrder(root.right)
    //    print(root.data+" ")
  }

  def insert(root: Node, key: Int): BSTFromPostorderAndPreorderSequence.Node = {
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

  // A recursive function to construct a full binary tree from given preorder
  //    // and postorder sequence
      def buildTree(preorder: Array[Int], pIndex: AtomicInteger, start: Int, end: Int, map: mutable.Map[Integer, Integer]): BSTFromPostorderAndPreorderSequence.Node = {
    // Consider the next item from the given preorder sequence
        // This item would be the root node of subtree formed by
        // the postorder[start, end] and increment pIndex
        val root = new Node(preorder(pIndex.getAndIncrement))
        // return if all keys are processed
        if (pIndex.get == preorder.length) return root
        // find the index of next key in postorder sequence to determine the
        // boundary of left and right subtree of current root node
        val index = map.getOrElse(preorder(pIndex.get),1).toString.toInt
        // fill the left and right subtree together
        if (start <= index && index + 1 <= end - 1) {
          // build the left subtree
          root.left = buildTree(preorder, pIndex, start, index, map)
//          else
          // build the right subtree
          root.right = buildTree(preorder, pIndex, index + 1, end - 1, map)
        }
        root
      }

  // Construct a full binary tree from preorder and postorder sequence
      def buildTree(preorder: Array[Int], postorder: Array[Int]): BSTFromPostorderAndPreorderSequence.Node = { // map is used to efficiently find index of any element in given
        // postorder sequence
        val map = new mutable.HashMap[Integer, Integer]
//        var map = collection.mutable.Map[Int,Int]
        var i = 0
        while ( {
          i < postorder.length
        }) {
          map.put(postorder(i), i)

          {
            i += 1; i - 1
          }
        }
        // pIndex stores index of next node in the preorder sequence
        val pIndex = new AtomicInteger(0)
        // set range [start, end] for subtree formed by postorder sequence
        val start = 0
        val end = preorder.length - 1
        // construct the binary tree and return it
        buildTree(preorder, pIndex, start, end, map)
      }
  // main function
      def main(args: Array[String]): Unit = {
        val preorder = Array(1, 2, 4, 5, 3, 6, 8, 9, 7)
        val postorder = Array(4, 5, 2, 8, 9, 6, 7, 3, 1)
        val root = buildTree(preorder, postorder)
        System.out.print("Inorder Traversal: ")
        inOrder(root)
      }



}
