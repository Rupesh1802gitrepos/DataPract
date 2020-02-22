package com.practicedatastructure

object BinaryTree {

def main (args: Array[String] ): Unit = {

val a = List(1,2,3,4,5,6,7,8)
  println(buildTree(a))

}
  sealed trait BinTree[+A]
  case object Leaf extends BinTree[Nothing]
  case class Branch[A](value: A, left: BinTree[A], right: BinTree[A]) extends BinTree[A]

  def buildTree[A](list: List[A]): BinTree[A] = list match {
        case Nil => Leaf
        case x :: xs => {
          val k = xs.length / 2
      Branch(x, buildTree(xs.take(k)), buildTree(xs.drop(k)))
    }
  }


}
