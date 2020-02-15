package com.practicedatastructure

object BstInsert {

  class Node(var data: Int) {
    var left: Node = null
    var right: Node = null
  }

  def insert(root: Node, key: Int): BstInsert.Node = {
    if (root == null)
      return new Node(key)
    if (key < root.data) {
      root.left = insert(root.left, key)
    }
    else {
      root.right = insert(root.right, key)
    }
    root
  }

  def main(args: Array[String]): Unit = {
    var root:Node = null
    var keys = Array(8,18,12,3,4,15,2,71,5,6,22)
    for(key<-keys){
      root = insert(root,key)
    }
  }
}
