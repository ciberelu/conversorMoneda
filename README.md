# 🌍 Conversor de Monedas

Este proyecto es una aplicación de consola desarrollada en **Java con Spring Boot** que permite convertir valores entre diferentes monedas en tiempo real.  
La aplicación consulta un servicio externo (API de tasas de cambio) para obtener las cotizaciones actualizadas y realiza las conversiones automáticamente.  

---

## 🚀 Funcionalidad

- Menú interactivo en la consola para elegir la conversión deseada.
- Conversión entre las siguientes monedas:
  - Dólar (USD) ⇆ Peso Argentino (ARS)
  - Dólar (USD) ⇆ Real Brasileño (BRL)
  - Dólar (USD) ⇆ Peso Colombiano (COP)
- Validación de entradas (monto válido y opciones correctas).
- Confirmación antes de salir del programa.
- Resultados mostrados en formato amigable.

---

## 🖥️ Ejemplo de uso

```bash
╔═══════════════════════════════════════════════╗
║        🌍 Bienvenido/a al Conversor 🌍        ║
╚═══════════════════════════════════════════════╝
1) USD => ARS
2) ARS => USD
3) USD => BRL
4) BRL => USD
5) USD => COP
6) COP => USD
7) Salir
Seleccione una opción: 1

Ingrese el monto que desea convertir: 100

✅ El valor de 100.00 [USD] corresponde a 35000.00 [ARS]

```
## 🛠️ Tecnologías utilizadas

Java 17+ → Lenguaje principal.

Spring Boot → Framework para estructurar el proyecto.

HTTP Client de Java → Consumo de la API externa.

API de tasas de cambio → Fuente de datos para las conversiones.

