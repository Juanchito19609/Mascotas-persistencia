# MascotasApp - Persistencia con SQLite

## Descripción

Esta versión de la aplicación MascotasApp implementa persistencia para guardar las últimas 5 mascotas calificadas usando una base de datos SQLite local.

---

## Cambios realizados

- Se agregó un identificador único (`id`) en el POJO `Mascota`.
- Se creó la clase `BaseDatos` para administrar la base SQLite.
- Se implementó la clase `MascotaDAO` para manejar operaciones CRUD.
- La app guarda automáticamente solo las últimas 5 mascotas calificadas.
- Se modificó el flujo para guardar las mascotas cada vez que se da un rating.

---

## Cómo probar

1. Ejecutar la app.
2. Calificar mascotas usando el ícono de hueso.
3. Ir a la sección de mascotas favoritas para verificar que se muestran las últimas 5 con rating.
4. Reiniciar la app para verificar que la información persiste.

---

## Modelo de base de datos

Tabla: `mascota`

| Columna  | Tipo    | Descripción                     |
| -------- | ------- | -------------------------------|
| id       | INTEGER | Identificador único (PRIMARY KEY) |
| nombre   | TEXT    | Nombre de la mascota            |
| foto     | INTEGER | Recurso drawable de la foto     |
| rating   | INTEGER | Cantidad de huesos/raiting      |

---

## Autor

Juan Esteban Franco Otálora  
Proyecto entregado como evidencia académica.
