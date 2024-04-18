// usuario.js
function crearUsuario(usuarioData) {
    $.ajax({
        type: "POST",
        url: "/api/usuarios",
        contentType: "application/json",
        data: JSON.stringify(usuarioData),
        success: function(response) {
            console.log("Usuario creado exitosamente:", response);
            // Actualizar la vista o realizar alguna otra acción después de crear el usuario
        },
        error: function(xhr, status, error) {
            console.error("Error al crear usuario:", error);
        }
    });
}

function obtenerUsuarios() {
    $.get("/api/usuarios", function(data) {
        console.log("Usuarios obtenidos:", data);
        // Actualizar la vista con la lista de usuarios obtenidos
    });
}

function actualizarUsuario(username, usuarioData) {
    $.ajax({
        type: "PUT",
        url: "/api/usuarios/" + username,
        contentType: "application/json",
        data: JSON.stringify(usuarioData),
        success: function(response) {
            console.log("Usuario actualizado exitosamente:", response);
            // Actualizar la vista o realizar alguna otra acción después de actualizar el usuario
        },
        error: function(xhr, status, error) {
            console.error("Error al actualizar usuario:", error);
        }
    });
}

function eliminarUsuario(username) {
    $.ajax({
        type: "DELETE",
        url: "/api/usuarios/" + username,
        success: function(response) {
            console.log("Usuario eliminado exitosamente:", response);
            // Actualizar la vista o realizar alguna otra acción después de eliminar el usuario
        },
        error: function(xhr, status, error) {
            console.error("Error al eliminar usuario:", error);
        }
    });
}
