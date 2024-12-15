package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ProgramacionRiegoOptimoParTest extends AnyFunSuite {
    test("ProgramacionRiegoOptimoPar encuentra la programación óptima en paralelo") {
        val finca = Vector((10, 3, 2), (15, 5, 1), (20, 4, 3))
        val distancia = Vector(
            Vector(0, 5, 10),
            Vector(5, 0, 15),
            Vector(10, 15, 0)
        )
        val (prog, costo) = App.ProgramacionRiegoOptimoPar(finca, distancia)
        assert(prog.nonEmpty)
        assert(costo >= 0)
    }

    test("ProgramacionRiegoOptimoPar devuelve programación vacía para una finca vacía") {
        val finca = Vector()
        val distancia = Vector()
        val (prog, costo) = App.ProgramacionRiegoOptimoPar(finca, distancia)
        assert(prog.isEmpty)
        assert(costo == 0)
    }

    test("ProgramacionRiegoOptimoPar es consistente con la versión no paralela") {
        val finca = Vector((10, 3, 2), (15, 5, 1))
        val distancia = Vector(
            Vector(0, 1),
            Vector(1, 0)
        )
        assert(App.ProgramacionRiegoOptimoPar(finca, distancia) == App.ProgramacionRiegoOptimo(finca, distancia))
    }

    test("ProgramacionRiegoOptimoPar encuentra correctamente el mínimo entre múltiples permutaciones") {
        val finca = Vector((10, 3, 2), (15, 5, 1), (20, 4, 3))
        val distancia = Vector(
            Vector(0, 1, 2),
            Vector(1, 0, 3),
            Vector(2, 3, 0)
        )
        val resultado = App.ProgramacionRiegoOptimoPar(finca, distancia)
        assert(resultado == (Vector(1, 0, 2),23)) // Costos manualmente calculados para validar
    }

    test("ProgramacionRiegoOptimoPar falla si las dimensiones de distancia no coinciden con los tablones") {
        val finca = Vector((10, 3, 2), (15, 5, 1))
        val distancia = Vector(
            Vector(0, 5) // Faltan filas
        )
        assertThrows[IndexOutOfBoundsException] {
            App.ProgramacionRiegoOptimoPar(finca, distancia)
        }
    }
}