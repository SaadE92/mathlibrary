package main.scala.math.matrix

/**
 * 
 */
object MatrixMultiplicationCli {
    def main(args: Array[String]): Unit = {
    val scanner = new java.util.Scanner(System.in)
    println("Enter first matrix columns number: ")
    val firstMatrixRowsNumber = scanner.nextLine().toInt
    println("Enter first matrix rows number: ")
    val firstMatrixColumnsNumber = scanner.nextLine().toInt
    println("Enter second matrix rows number: ")
    val secondMatrixRowsNumber = scanner.nextLine().toInt
    println("Enter second matrix columns number: ")
    val secondMatrixColumnsNumber = scanner.nextLine().toInt
    
    try{
      val matrixCreator : MatrixCreator = new MatrixCreator(firstMatrixRowsNumber,secondMatrixColumnsNumber)
    }catch{
      case e: IllegalArgumentException => println("Error in second matrix dimensions: please provide same column numbers as first matrix rows number")
      System.exit(0)
    }
    def getMatrixContent(matrixDim:Int, matrixPosition:String):Array[Array[Int]]={
        var i = 0
        var matrixContent : Array[Array[Int]] = Array.empty
        while(i<matrixDim){
          println(String.format("Please provide %s matrix line "+ i +" numbers separated by a space:",matrixPosition))
            var line : Array[Int]= scanner.nextLine().split(" ").map(_.toInt)
            matrixContent = matrixContent ++ Array(line) 
            i+=1
        }
        matrixContent
    }
    val matrixCreatorWithValues = new MatrixCreator(getMatrixContent(firstMatrixColumnsNumber,"first"),getMatrixContent(secondMatrixRowsNumber, "second"))    
    (matrixCreatorWithValues.A * matrixCreatorWithValues.B).values foreach { row => row.foreach(v => print(v + " ")); println }
  }
}