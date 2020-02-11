package com.practicedatastructure

object FindingDuplicatesInArray {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 3, 1, 3, 6, 6)
    val result = checkUnique(arr) //.toList.map(x => println(x)))
    result.toList.map(x => println(x))
  }
  def checkUnique (arr:Array[Int]):Array[Int] = {
    var resultarr = Array[Int]()
    for (i <- 0 to arr.length-1)
      {
        if (arr(Math.abs(arr(i))) > 0){
          arr(Math.abs(arr(i))) = -arr(Math.abs(arr(i)))
        }
        else {
          resultarr =  resultarr :+ Math.abs(arr(i))

        }
      }
    resultarr
  }

}
