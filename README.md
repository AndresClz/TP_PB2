# Sistema de Cazadores de Recompensas

## Descripción

Este proyecto tiene como objetivo desarrollar un sistema colaborativo que modele el universo de cazadores de recompensas y prófugos. Fue diseñado para aplicar conceptos de programación orientada a objetos, fomentar el trabajo en equipo y practicar el uso de control de versiones con GitHub.

## Objetivos

- Modelar distintas clases de cazadores y prófugos con comportamientos específicos.
- Implementar principios de diseño como herencia, polimorfismo y composición.
- Aplicar Test Driven Development (TDD) para garantizar la calidad del código.
- Fomentar la colaboración activa mediante el uso de GitHub (issues, pull requests, revisiones).

## Estructura del Proyecto

El proyecto está organizado en paquetes y clases principales para mantener un diseño claro y modular.

## Cómo colaborar

- Crear una rama nueva para cada funcionalidad o corrección.
- Hacer commits pequeños y descriptivos.
- Abrir pull requests y asignar a tu compañero para revisión.
- Mantener comunicación activa usando issues y comentarios.

## Próximos pasos
- Completar las firmas de métodos y documentar su comportamiento esperado.
- Definir casos de prueba iniciales (tests rojos) para cada clase clave.
- Implementar lógica paso a paso siguiendo el ciclo TDD (Rojo → Verde → Refactor).
## Verificación de Requerimientos en los Tests

La estructura de los tests está organizada por unidad de responsabilidad y no por requerimiento. A continuación se detalla qué archivos de prueba cubren cada uno de los requerimientos funcionales principales:

---

### **Parte I: Proceso de Captura**

> **Requerimiento:** *Hacer que un cazador realice el proceso de captura en una zona, capturando los prófugos que pueda e intimidando al resto. La zona debe quedar sin los prófugos capturados.*

Para verificar este flujo, revise el archivo:
*   **`test/ar/unlam/edu/ar/tp/cazador/CazadorTest.java`**

Este archivo contiene los tests que simulan la operación completa a través del `ServicioDeCaptura`, asegurando que los cazadores capturen, intimiden y que la zona se actualice correctamente. Tests clave como `queCazadorCaptureYRemuevaDeZona` y `queCazadorCaptureYObtengaExperienciaCorrectamente` validan este comportamiento.

---

### **Parte II: Evolución de Prófugos**

> **Requerimiento:** *Los Prófugos pueden entrenarse para mejorar sus habilidades (Artes marciales, Entrenamiento de elite, Protección legal) y acumular estas mejoras.*

Para verificar la correcta evolución de los prófugos, revise el archivo:
*   **`test/ar/unlam/edu/ar/tp/profugo/ProfugoDecoradorTest.java`**

Este archivo se dedica a probar el patrón Decorator. Contiene pruebas que validan cada habilidad por separado y, lo más importante, tests que combinan múltiples "capas" de entrenamiento sobre un mismo prófugo para asegurar que las habilidades se acumulan correctamente.

---

### **Parte III: Reportes de la Agencia**

> **Requerimiento:** *Obtener reportes sobre todos los prófugos capturados, el prófugo más hábil y el cazador con más capturas.*

Para verificar que los reportes de la agencia funcionan, revise el archivo:
*   **`test/ar/unlam/edu/ar/tp/AgenciaTest.java`**

Este archivo contiene tests específicos para cada método de reporte:
-   `queSePuedaRegistrarCaptura` (verifica la lista general de capturados).
-   `queDevuelvaElProfugoMasHabilCapturado`.
-   `queDevuelvaCazadorConMasCapturasTrasOperacionSecuencialConIntimidacion`.