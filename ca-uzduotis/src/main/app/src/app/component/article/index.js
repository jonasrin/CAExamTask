import React from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import './index.css';
import Comment from '../comment';



function Article() {
    return (
        <div>
            <h1>Article header</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam auctor luctus tortor in commodo. Praesent tempus, velit et semper condimentum, massa justo tincidunt ipsum, a congue tellus mi a tortor. Phasellus suscipit volutpat nulla nec porta. Maecenas sit amet orci sollicitudin, pharetra erat id, venenatis augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec et porttitor lorem. Suspendisse rhoncus vitae nisi sit amet faucibus. Donec hendrerit velit vitae ex pharetra ultrices. Etiam iaculis sollicitudin interdum. In rhoncus cursus sollicitudin. Vestibulum justo orci, consequat vel rutrum at, vehicula quis mauris. Mauris et leo sollicitudin erat tincidunt semper venenatis at sapien. Pellentesque nulla sapien, sollicitudin vitae lobortis nec, dignissim non quam.

Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin nec ligula rutrum, pellentesque tellus eget, convallis dolor. Integer et eleifend tellus. Vivamus viverra lectus enim, in aliquet nisi mattis ut. Donec sapien neque, faucibus in iaculis vel, ornare sed neque. Mauris fringilla sapien at magna imperdiet commodo. Suspendisse volutpat sagittis ex venenatis fermentum.

Praesent nec tincidunt diam. Interdum et malesuada fames ac ante ipsum primis in faucibus. Donec at quam sed nulla sagittis aliquam a vel ex. Proin ullamcorper vestibulum lectus, quis fringilla lectus pretium sit amet. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Donec sapien sapien, feugiat sodales iaculis id, porttitor non dolor. Morbi est sapien, laoreet et sapien ac, gravida fermentum orci. Duis rutrum euismod turpis, ac porta lorem condimentum vitae. Suspendisse lacus neque, interdum eu elementum id, congue et tellus. Vestibulum ex odio, ullamcorper eu porta a, aliquet vitae quam. Sed nec aliquet leo. Maecenas augue felis, suscipit non odio et, eleifend sagittis diam. Donec id dignissim dui. Donec justo arcu, molestie et rutrum ac, fringilla eget quam. Vestibulum et imperdiet nibh. Fusce efficitur dignissim neque, sed dignissim orci gravida et.

Praesent posuere finibus nisi in pulvinar. Morbi eu nisi eu ipsum vestibulum laoreet quis sed erat. Nullam felis sem, pharetra vitae orci ut, vehicula congue urna. Morbi quis pellentesque ligula. Suspendisse et finibus massa, sit amet mollis mauris. Nam eu libero egestas, accumsan sem a, laoreet arcu. Duis convallis erat eu condimentum efficitur. Etiam viverra, libero sed elementum bibendum, odio mauris dictum eros, et tristique odio sem in felis. Sed dapibus massa id libero gravida, et iaculis turpis congue. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum nunc ex, ornare non orci at, faucibus elementum magna. Donec sollicitudin consequat nisl, eget venenatis enim varius id. Proin velit odio, lobortis vel augue eget, maximus ultricies ipsum. Maecenas elementum, lectus et sodales egestas, lorem orci congue eros, ac efficitur leo mauris at nulla. Morbi placerat erat vitae nisl faucibus, quis finibus lectus elementum.

Nulla facilisi. In hac habitasse platea dictumst. Nullam sit amet vehicula mi, nec pretium risus. Suspendisse quis dui sed purus facilisis ullamcorper. Nam gravida orci vitae interdum malesuada. Ut sodales augue et tellus egestas vestibulum. Duis ultricies odio nunc, vel placerat velit fringilla in. Suspendisse porttitor eros lacus, vel porta risus fringilla eget. In hac habitasse platea dictumst. Pellentesque quis lectus felis. Mauris sed viverra leo, at ornare dolor. Duis ornare diam eu ante aliquam convallis eu vel nisl. Maecenas condimentum, leo sit amet finibus fermentum, mi mauris varius metus, sed suscipit metus arcu vel sem. Donec congue tellus vitae felis pellentesque maximus. Curabitur pretium, nisl at dignissim porttitor, orci augue scelerisque dui, rutrum aliquam ante augue ac massa. Etiam id dolor quis ex efficitur pretium in eget nunc.</p>
            <p>Author: Ksysia</p>

            <Comment />
        </div>
    );
}

export default Article;