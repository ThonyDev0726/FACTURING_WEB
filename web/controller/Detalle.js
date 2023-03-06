document.addEventListener("DOMContentLoaded", init, true);

function init() {
    document.querySelector("#btn-agregar").addEventListener("click", agregarDetalle, true);

    function agregarDetalle(e) {
        e.preventDefault();
        var txtIdProd = document.querySelector("#lbl-id-producto");
        var txtProCantidad = document.querySelector("#lbl-pro-stock");
        var txtProPrecio = document.querySelector("#lbl-pro-stock");
        var txtProTotal = 100;
        var userdata = '{"txtIdProd":' + parseInt(txtIdProd.value)  +
                ',"txtProCantidad":' + parseInt(txtProCantidad.value) +
                ',"txtProTotal":' + txtProTotal + '}';
        if (txtIdProd.value == '' && txtProdNombre.value == '') {
            Swal.fire(
                    {
                        icon: 'info',
                        text: '¡Ningun campo debe estar vacio!',
                        toast: true,
                        position: 'top',
                        showConfirmButton: false,
                        timer: 2500
                    }
            );
        } else {
            agregarDatosProducto(userdata);
        }
        //console.log(userdata.toString());
    }

    function agregarDatosProducto(data) {
        var request = new XMLHttpRequest();
        request.open("POST", "AgregarDetalle", true);
        request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        request.onreadystatechange = function () {
            // si la respuesta fue exitosa
            if (request.readyState == 4 && request.status == 200) {
                var message = request.responseText;
                switch (message) {
                    case'Iniciar sesion':
                        Swal.fire(
                                {
                                    icon: 'error',
                                    text: '¡Inicie sesion de nuevo, por favor!',
                                    showConfirmButton: false,
                                    timer: 2000,
                                    width: 300,
                                    heigth: 400
                                });
                        setTimeout(function () {
                            window.location.href = "CerrarSesion";
                        }, 2000);
                        break;
                    case'Stock insuficiente':
                        Swal.fire(
                                {
                                    icon: 'error',
                                    text: 'El stock es insuficiente',
                                    toast: true,
                                    position: 'top',
                                    showConfirmButton: false,
                                    timer: 2500
                                }
                        );
                        break;
                    case'Producto agregado':
                        Swal.fire(
                                {
                                    icon: 'success',
                                    text: 'Producto agregado y stock actualizado',
                                    toast: true,
                                    position: 'top',
                                    showConfirmButton: false,
                                    timer: 2500
                                });
                        var txtProNombreTbl = document.querySelector("#lbl-pro-stock");
                        var txtProCodigoTbl = document.querySelector("#lbl-pro-precio");
                        var txtProCantidadTbl = document.querySelector("#lbl-pro-precio");
                        var txtProPrecioTbl = document.querySelector("#lbl-pro-precio");
                        var txtProTotalTbl = txtProCantidadTbl.value * txtProPrecioTbl.value;
                        var row = "<tr><td>" + rowNum
                                + "</td><td>" + childData.txtProNombreTbl.value
                                + "</td><td>" + childData.txtProCodigoTbl.value
                                + "</td><td>" + childData.txtProCantidadTbl.value
                                + "</td><td>" + childData.txtProPrecioTbl.value
                                + "</td><td>" + childData.txtProTotalTbl.value
                                + "</td></tr>"
                        $(row).appendTo('#tablaDetalle');
                        break;
                }
//            
            }
            // si la respuesta trajo error
            else if (request.readyState == 4 && request.status != 200) {
                var message = request.responseText;
                message = request.responseText;
                //console.log(message)
                Swal.fire(
                        {
                            icon: 'error',
                            text: 'No se pudo procesar tu peticion',
                            toast: true,
                            position: 'top',
                            showConfirmButton: false,
                            timer: 2500
                        });
            }
        };
        request.send("datosProducto=" + data);
    }



}
