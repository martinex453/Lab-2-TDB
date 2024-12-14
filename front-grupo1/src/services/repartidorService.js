import httpClient from '../http-common';

const getRepartidorByZone = (zone) => {
    return httpClient.get('/repartidor/getByZona', zone);
}