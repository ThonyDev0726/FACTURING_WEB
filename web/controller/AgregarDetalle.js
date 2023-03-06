document.addEventListener("DOMContentLoaded", init, true);

function init() {
    document.querySelector("#btn-agregar").addEventListener("click", handleLogin, true);

    function handleLogin(e) {
        e.preventDefault();

        var txtIdProd = document.getElementById("txtIdProd");
        var txtProCantidad = document.getElementById("txtProCantidad");
        var txtProPrecio = document.getElementById("txtProPrecio");
        var txtProTotal = (txtProCantidad.value * txtProPrecio.value);

        var userdata = '{"txtIdProd":' + txtIdProd.value
                + ',"txtProTotal":' + txtProTotal
                + ',"txtProCantidad":' + txtProCantidad.value + '}';
        if (txtIdProd.value == '' && txtProCantidad.value == '') {
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
            loginByAjax(userdata);
        }
    }

    function loginByAjax(data) {
        var request = new XMLHttpRequest();
        request.open("POST", "AggDetalle", true);
        request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        request.onreadystatechange = function () {
            // si la respuesta fue exitosa
            if (request.readyState == 4 && request.status == 200) {
                var message = request.responseText;
                switch (message) {
                    case'Stock insuficiente':
                        Swal.fire(
                                {
                                    icon: 'warning',
                                    text: '¡Stock insuficiente!',
                                    toast: true,
                                    position: 'top',
                                    showConfirmButton: false,
                                    timer: 2500
                                }
                        );
                        document.querySelector("#password_input").value = '';
                        break;

                    case'Producto agregado':
                        Swal.fire(
                                {
                                    icon: 'success',
                                    text: '¡Producto agregado!',
                                    toast: true,
                                    position: 'top',
                                    showConfirmButton: false,
                                    timer: 2500
                                });
                        var fila = "<tr class='btn-reveal-trigger'><td class='text-center'>" +
                                "<div class='text-sans-serif py-2>" +
                                "<button class='btn btn-danger' type='button'>"
                                + "<i class='fas fa-trash mr-1 primary' style='cursor: pointer;'></i>"
                                + "</button>"
                                + "</div>"
                                + "</td><td class='text-center'>" + document.getElementById('lbl-pro-nombre').value
                                + "</td><td class='text-center'>" + document.getElementById('lbl-pro-codigo').value
                                + "</td><td class='text-center'>" + document.getElementById('txtProCantidad').value
                                + "</td><td class='text-center'>" + document.getElementById('txtProPrecio').value
                                + "</td><td class='text-center'>" + (document.getElementById('txtProCantidad').value * document.getElementById('txtProPrecio').value)
                                + "</td></tr>"
                        $(fila).appendTo('#tablaDetalle');
                        //Defino los totales de mis 2 columnas en 0
                        var total_col1 = 0;
                        //Recorro todos los tr ubicados en el tbody
                        $('#tablaDetalle tbody').find('tr').each(function (i, el) {

                            //Voy incrementando las variables segun la fila ( .eq(0) representa la fila 1 )     
                            total_col1 += parseFloat($(this).find('td').eq(5).text());

                        });
                        //Muestro el resultado en el th correspondiente a la columna
                        document.getElementById('SubTotalPagar').innerHTML = '$ ' + total_col1;
                        document.getElementById('TotalPagar').innerHTML = '$ ' + total_col1;
                        break;
                    case'Iniciar sesion':
                        Swal.fire(
                                {
                                    icon: 'error',
                                    text: '¡Tiempo agotado!',
                                    toast: true,
                                    position: 'top',
                                    showConfirmButton: false,
                                    timer: 2500
                                });
                        setTimeout(function () {
                            window.location.href = "CerrarSesion";
                        }, 2000);
                        break;
                }
            }
            // si la respuesta trajo error
            else if (request.readyState == 4 && request.status != 200) {
                var message = request.responseText;
                message = request.responseText;
                console.log(message)
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
        request.send("datosUsuario=" + data);
    }

    function sumar() {
        var total = 0;
        var tabla = document.getElementById('tablaDetalle')

        for (var i = 0; tabla.rows[i]; i++) {
            total += Number(tabla.rows[i].cells[5].innerHTML) * document.getElementById(i).value;
        }
        return total
    }
}

