package main.scala.math.matrix

/**
 * 
 */
class Matrix(val values:Array[Array[Int]]) extends AbstractMatrix{

def matrixTimesMatrix(matrix1 : Matrix):Matrix={
    def rowTimesColumn(row: Array[Int], column: Array[Int]) :Int =
    		if(row.length > 0 && row.length == column.length) row.head*column.head + rowTimesColumn(row.tail, column.tail) else 0
    		
    		
  	def rowTimesMatrix(f:((Array[Int],Array[Int]) => Int))(row: Array[Int])(matrix : Matrix) : Array[Int] =
  			if(matrix.values.length > 0) (Array(f(row, matrix.values.head)) ++ rowTimesMatrix(f)(row)(new Matrix(matrix.values.tail)))
  			else Array.emptyIntArray
  	
  	if(matrix1.values.length > 0)
  			new Matrix(Array(rowTimesMatrix(rowTimesColumn)(matrix1.values.head)(this))++matrixTimesMatrix(new Matrix(matrix1.values.tail)).values)
    else new Matrix(Array.empty)
  }
 
 def *(matrix:Matrix) : Matrix = matrixTimesMatrix(matrix)
}