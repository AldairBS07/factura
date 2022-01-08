# Factura


# Ruta principal /api/factura
# POST | Ruta para añadir una nueva factura  /api/factura/guardar 
# GET | Ruta para listar todas las facturas  /api/factura/listar
# DELETE | Ruta para eliminar una factura  /api/factura/eliminar/{codigo}
# PUT | Ruta para actualiar una factura /api/factura/actualizar/{codigo}
# GET | Ruta para listar factura por RUC /api/factura/actualizar/{codigo}


# DetalleFactura


# Ruta principal /api/factura/detalle
# POST | Ruta para añadir una nuevo detalle a la factura  /api/factura/detalle/guardar/{codigo}
# GET | Ruta para listar el detalle de una factura por RUC  /api/factura/detalle/listar/{RUC}
# DELETE | Ruta para eliminar un detalle por el codigoFactura /api/factura/detalle/eliminar/{codigoFactura}

# Cabe recalcar que no es seguro pasar parametros en la URL en un metodo POST, PUT O DELETE.
