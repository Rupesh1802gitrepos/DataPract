package com.practicedatastructure

object SearchInBST {
  class Node(var data: Int) {
    var left: Node = null
    var right: Node = null
  }
  def insert(root: Node, key: Int): SearchInBST.Node = {
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

  def search(root:Node, key:Int): Int ={
    if(root==null){
      println("root is null")
      return 0
    }
    else if(root.data == key ){
      println("found")
    }
    if(key<root.data){
      return search(root.left,key)
    }else if(key>root.data)
      return search(root.right,key)

    return root.data
  }

  def main(args: Array[String]): Unit = {
    var root:Node = null
    var keys = Array(8,18,12,3,4,15,2,71,5,6,22)
     for (key <- keys) {
       root = insert(root,key)
       search(root,5)
     }
//    var root1:Node = 8
//    search(8,18)

  }


}
