import { useEffect, useState, setData } from "react";
import { API_DOMAIN, API_ENDPOINTS } from "./constants";
const put = async (url, body, id) => {
    return fetch(`${API_DOMAIN}${url}` + id,
        {
            body: JSON.stringify(body),
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-type': 'application/json'
            }
        }
    ).then(resp => resp.json());
};

export { put };