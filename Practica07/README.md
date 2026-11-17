# Práctica 7: Introducción a la Programación Orientada a Objetos
**Introducción a las Ciencias de la Computación (Semestre 2027-1)**  
**Facultad de Ciencias, UNAM**

---

## Datos del alumno

- **Nombre completo:** Omar Romero Arzate
- **Número de cuenta:** 121006480

---

## Descripción del proyecto
Sistema para una empresa de paquetería que cotiza envíos a partir de los datos de cada paquete. La solución se organizó en tres clases:

- `Paquete`: representa un paquete (código de rastreo, peso, largo, ancho, alto, valor declarado y si es frágil). Sus atributos son privados y se modifican solo mediante el constructor o los setters, que validan los datos. Calcula el peso volumétrico, el peso cobrable y, como propuesta personal, el importe extra por manejo de paquete frágil (`calcularImporteFragil()`).
- `CotizadorEnvio`: clase de utilería con métodos estáticos. Valida un paquete (incluyendo el caso `null`), cotiza el envío con la tarifa por rangos de peso y determina si requiere seguro obligatorio.
- `PruebaPaqueteria`: programa de prueba con los casos de la práctica, las pruebas de la propuesta personal y algunas validaciones extra.

---

## Comandos para compilar, ejecutar y documentar

Los comandos se ejecutan desde la raíz de la carpeta `Practica07`.

### 1. Compilación
```bash
javac -d bin src/*.java
```

### 2. Ejecución
```bash
java -cp bin PruebaPaqueteria
```

### 3. Generación de documentación Javadoc
```bash
javadoc -d doc -author -version src/*.java
```

