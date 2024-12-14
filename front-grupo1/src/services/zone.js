import httpClient from '../http-common';

const getAreaByCompany = (company) => {
    return httpClient.get('/empresa/area_zonas', company);
}