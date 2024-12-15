package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CostoRiegoFincaTest extends AnyFunSuite {
  
  
  
  test("Costo de riego en finca pequeña (3 tablones)") {
    val finca = Vector((10, 2, 1), (8, 3, 2), (15, 1, 3))
    val prog = Vector(0, 1, 2)
    val resultado = App.costoRiegoFinca(finca, prog)
    
    assert(resultado == 20)
  }

  test("Costo de riego con finca de 2 tablones") {
    val finca = Vector((10, 5, 1), (12, 4, 3))
    val prog = Vector(0, 1)
    val resultado = App.costoRiegoFinca(finca, prog)
   
    assert(resultado == 8)

  }

  test("Costo de riego con finca con un solo tablón") {
    val finca = Vector((20, 5, 1))
    val prog = Vector(0)
    val resultado = App.costoRiegoFinca(finca, prog)
    
    // Solo hay un tablón, el costo será solo del riego de ese tablón
    assert(resultado == 15)
  }

  test("Costo de riego con finca vacía") {
    val finca = Vector()
    val prog = Vector()
    val resultado = App.costoRiegoFinca(finca, prog)
    
    // Finca vacía, sin costo
    assert(resultado == 0)
  }

  test("Costo de riego con finca y distancias muy altas entre tablones") {
    val finca = Vector((100, 5, 1), (150, 4, 2))
    val prog = Vector(1, 0)
    val resultado = App.costoRiegoFinca(finca, prog)
    
    // Evaluar costo esperado con distancias altas
    assert(resultado == 237)
  }
}
