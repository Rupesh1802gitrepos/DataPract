package com.practicedatastructure

import scala.collection.mutable

object SubArrayWithSum0Exist {
  def main(args: Array[String]): Unit = {
    val arr1 = Array(-3, 2, 3, 1, 6)
    val arr2 =Array(6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7)

    val result = checksubarrayexistwithsum0(arr2)
    println(result)
  }

  /**
    *
    * @param  it takes an Array and check if it contains a subArray whose sum is 0 ,
    * @return return an Boolean
    */

  def checksubarrayexistwithsum0(arr :Array[Int]):Boolean ={
    var sum = 0
    var result:Boolean = false

    val store_prefix_sum = mutable.Map[Int,Int]()
    var store_prefix_sum_list = List[Int]()
    for (i <- 0  until arr.length-1){
      sum = sum + arr(i)
      if (arr(i) == 0 || sum == 0 || store_prefix_sum_list.contains(sum)) {
        result =  true
      }
      store_prefix_sum_list = store_prefix_sum_list :+ sum
    }
    result
  }


}
