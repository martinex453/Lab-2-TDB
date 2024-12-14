import httpClient from '../http-common';

const AreaCompany = (company) => {
    return httpClient.get('/empresa/area_zonas', company);
}