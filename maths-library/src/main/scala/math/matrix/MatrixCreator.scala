package main.scala.math.matrix

/**
 * 
 */
class MatrixCreator(val firstColNum:Int, val firstRowNum:Int, val firstMatrixValues:Array[Array[Int]],val secondColNum:Int, val secondRowNum:Int, val secondMatrixValues:Array[Array[Int]]){

    /**
   * A secondary constructor.
   */
  def this(firstRowNum: Int, secondColNum:Int) {
    this(0,firstRowNum, Array.empty,secondColNum, 0, Array.empty);
  }
  
  def this(firstMatrixValues:Array[Array[Int]],secondMatrixValues:Array[Array[Int]]) = this(0,0,firstMatrixValues,0,0,secondMatrixValues)
    
  def A:Matrix = new Matrix(firstMatrixValues)
	
  if(firstRowNum != secondColNum) throw new IllegalArgumentException("Please provide a second matrix column numbers equalling first matrix row number")
	
  def B:Matrix = new Matrix(secondMatrixValues)
}