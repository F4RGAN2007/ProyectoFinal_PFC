package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CostoMovilidadTest extends AnyFunSuite {
  

  
  test("Costo de movilidad en finca pequeña (3 tablones)") {
    val finca = Vector((10, 2, 1), (8, 3, 2), (15, 1, 3))
    val distancia = Vector(Vector(0, 4, 7), Vector(4, 0, 5), Vector(7, 5, 0))
    val prog = Vector(0, 1, 2)
    val resultado = App.costoMovilidad(finca, prog, distancia)
    
    // Evaluar costo de movilidad entre tablones según la programación
    assert(resultado == 9)  // Costo esperado: distancias entre 0-1 y 1-2
  }

  test("Costo de movilidad con finca de 2 tablones") {
    val finca2 = Vector((10, 5, 1), (12, 4, 3))
    val distancia2 = Vector(Vector(0, 3), Vector(3, 0))
    val prog2 = Vector(0, 1)
    val resultado = App.costoMovilidad(finca2, prog2, distancia2)
    
    // Cálculo de la distancia 0-1
    assert(resultado == 3)
  }

  test("Costo de movilidad con finca con un solo tablón") {
    val finca3 = Vector((20, 5, 1))
    val distancia3 = Vector(Vector(0))
    val prog3 = Vector(0)
    val resultado = App.costoMovilidad(finca3, prog3, distancia3)
    
    // No hay movimiento, por lo que el costo debe ser 0
    assert(resultado == 0)
  }

  test("Costo de movilidad con finca vacía") {
    val fincaVacia = Vector()
    val distanciaVacia = Vector()
    val progVacia = Vector()
    val resultado = App.costoMovilidad(fincaVacia, progVacia, distanciaVacia)
    
    // Finca vacía, no hay costos de movilidad
    assert(resultado == 0)
  }

  test("Costo de movilidad con finca y distancias muy altas entre tablones") {
    val finca4 = Vector((100, 5, 1), (150, 4, 2))
    val distancia4 = Vector(Vector(0, 200), Vector(200, 0))
    val prog4 = Vector(1, 0)
    val resultado = App.costoMovilidad(finca4, prog4, distancia4)
    
    // Cálculo de la distancia entre tablones
    assert(resultado == 200)
  }
}
