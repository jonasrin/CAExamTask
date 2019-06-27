import { useEffect, useState, setData } from "react";
import { API_DOMAIN, API_ENDPOINTS } from "./constants";
const post = async (url, body) => {
    return fetch(`${API_DOMAIN}${url}`,
        {
            body: JSON.stringify(body),
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-type': 'application/json'
            }
        }
    ).then(resp => resp.json());
};

export { post };