import httpClient from "../http-common";

const getAll = (token) => {
    //Obtener todas las zonas
    return httpClient.get("/zona/All", {
        headers: {
            Authorization: `Bearer ${token}`,
        },
    });
};

const getRepartidores = (id, token) => {
    //Obtener los repartidores de una zona
    return httpClient.get(`/repartidor/getByZona/${id}`, {
        headers: {
            Authorization: `Bearer ${token}`,
        },
    });
};

const getZonas = (tipo, token) => {
    //Obtener las zonas segun su tipo
    return httpClient.get(`/zona/getZonasValidas?tipo=${tipo}`, {
        headers: {
            Authorization: `Bearer ${token}`,
            },
    });
};

export default {
    getAll, getZonas, getRepartidores,
    getRepartidores
};