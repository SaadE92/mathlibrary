package main.scala.math.matrix

/**
 * Matrix class, implements tail recursive functions to perform matrix multiplication
 */
class Matrix(val values:Array[Array[Int]]) extends AbstractMatrix{

  /**
   * Method to multiply current Matrix object with passed parameters.
   * This method defines 2 local methods: - rowTimesColumn: multiplies two sequences of integers with same length. (Should remind of how you get table with matrix multiplication formula)
   * 																			- rowTimesMatrix: uses above method to perform a row times matrix multiplication which should yield a matrix line.
   * matrixTimesMatrix method uses in sequence the two methods to compute lines and cell multiplication to yield the matrix product  
   */
def matrixTimesMatrix(matrix1 : Matrix, matrixResult: Matrix):Matrix={
    def rowTimesColumnUnWrapped(row: Array[Int], column: Array[Int], acc:Int) :Int =
    		if(row.length > 0 && row.length == column.length)  rowTimesColumnUnWrapped(row.tail, column.tail, row.head*column.head + acc) else acc
    		
    def rowTimesColumn(row: Array[Int], column: Array[Int]):Int=rowTimesColumnUnWrapped(row, column, 0)
    		
  	def rowTimesMatrixUnWrapped(f:((Array[Int],Array[Int]) => Int))(row: Array[Int])(matrix : Matrix)(acc:Array[Int]) : Array[Int] =
  			if(matrix.values.length > 0) rowTimesMatrixUnWrapped(f)(row)(new Matrix(matrix.values.tail))(Array(f(row, matrix.values.head)) ++ acc)
  			else acc
  	
  	def rowTimesMatrix(f:((Array[Int],Array[Int]) => Int))(row: Array[Int])(matrix : Matrix):Array[Int]=rowTimesMatrixUnWrapped(f)(row)(matrix)(Array.emptyIntArray)
  			
  	if(matrix1.values.length > 0)
  			new Matrix(matrixTimesMatrix(new Matrix(matrix1.values.tail), new Matrix(Array(rowTimesMatrix(rowTimesColumn)(matrix1.values.head)(this))++matrixResult.values)).values)
    else matrixResult
  }
 
 def *(matrix:Matrix) : Matrix = matrixTimesMatrix(matrix, new Matrix(Array.empty))
}