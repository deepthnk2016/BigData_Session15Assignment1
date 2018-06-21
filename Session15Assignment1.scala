/**
 * Author - Deepak Ray
 * Date - 08/05/2018
 * Description - BigData_Session15Assignment1
 *               Program to show inheritance concept in Scala
 */
import java.util.Scanner;
// Parent Class Calculator having basic functions
class Calculator(firstOperand: Int, secondOperand: Int, oper: String) {
  var firstNo: Int = firstOperand;
  var secondNo: Int = secondOperand;
  var result: Int = 0
  def calculate = {

    if (oper.equalsIgnoreCase("A")) result = firstNo + secondNo;
    if (oper.equalsIgnoreCase("S")) result = firstNo - secondNo;
    if (oper.equalsIgnoreCase("M")) result = firstNo * secondNo;
    if (oper.equalsIgnoreCase("D")) result = firstNo / secondNo;

  }

  def displayoutput = {
    println("First Number = " + firstNo)
    println("Second Number = " + secondNo)
    println("Operation = " + oper)
    println("Result = " + result)

  }

}

//Child class Scientific Calculator extending the base class
class ScientificCalculator(firstOperand: Int, secondOperand: Int, oper: String) extends Calculator(firstOperand, secondOperand, oper) {
  override def calculate = {
    // If advance function then perform it else call parent class method calculate
    if (oper.equalsIgnoreCase("E")) result = firstOperand % secondOperand
    else super.calculate
  }
}

object Session15Assignment1 {

  def main(args: Array[String]) {
    //Accept first no, second no and operation from console
    var scan: Scanner = new Scanner(System.in)
    print("Enter first number:")
    var firstnumber: Int = scan.nextInt();
    print("Enter Second number:")
    var secondnumber: Int = scan.nextInt();
    println("Enter Operation:")
    println("A - Addition, S - Subtraction, M - Multiplication")
    println("D - Division, E - Mod")
    var operation: String = scan.next()

    //Instantiate child class object
    var calc = new ScientificCalculator(firstnumber, secondnumber, operation);
    scan.close();

    //Invoke the calculate method
    calc.calculate

    //Invoke the display method
    calc.displayoutput
  }
}
