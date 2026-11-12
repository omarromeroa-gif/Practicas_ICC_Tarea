# Práctica 8: Mini-Lab (La Clase Punto)

## Datos del Alumno
* **Nombre:** [Omar Romero Arzate]
* **Número de Cuenta:** [121006480]

## Preguntas de Reflexión

**1. Diferencia entre `puntoMedio` y `desplazar` respecto al estado del objeto:**
`desplazar` modifica directamente las coordenadas del punto original, mientras que `puntoMedio` no toca los puntos originales y crea uno nuevo con el resultado.

**2. ¿A qué objeto hace referencia `this` en la llamada `p1.distancia(p2)`?**
Hace referencia a `p1`, porque es el objeto desde el cual se está mandando a llamar el método.

**3. ¿Por qué los métodos en `PruebaPunto` y en clases como `Math` son `static`?**
Porque son funciones de ayuda que se pueden usar directamente con el nombre de la clase, sin tener que crear un objeto con `new` primero.

## Evidencia de Ejecución
Al compilar y ejecutar las pruebas de unidad con `PruebaPunto`, el código superó todas las validaciones correctamente:

```text
================================================================================
RESUMEN DE PRUEBAS: 21 / 21 pruebas superadas con éxito.
¡FELICIDADES! Todos los metodos de la clase Punto funcionan correctamente.
================================================================================
