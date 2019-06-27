import { useEffect, useState, setData } from "react";
import { API_DOMAIN, API_ENDPOINTS } from "./constants";
const delRest = async (url, id) => {
    // alert(`${API_DOMAIN}${url}${id}`);
    return fetch(`${API_DOMAIN}${url}` + id,
        {
            // id: JSON.stringify(id),
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-type': 'application/json'
            }
        }
    ).then(resp => resp.status);
};

export { delRest };