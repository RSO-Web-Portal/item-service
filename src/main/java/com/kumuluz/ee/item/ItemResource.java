/*
 *  Copyright (c) 2014-2017 Kumuluz and/or its affiliates
 *  and other contributors as indicated by the @author tags and
 *  the contributor list.
 *
 *  Licensed under the MIT License (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  https://opensource.org/licenses/MIT
 *
 *  The software is provided "AS IS", WITHOUT WARRANTY OF ANY KIND, express or
 *  implied, including but not limited to the warranties of merchantability,
 *  fitness for a particular purpose and noninfringement. in no event shall the
 *  authors or copyright holders be liable for any claim, damages or other
 *  liability, whether in an action of contract, tort or otherwise, arising from,
 *  out of or in connection with the software or the use or other dealings in the
 *  software. See the License for the specific language governing permissions and
 *  limitations under the License.
*/
package com.kumuluz.ee.item;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


import com.kumuluz.ee.logs.cdi.Log;
import com.kumuluz.ee.logs.cdi.LogParams;


@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("items")
@Log(LogParams.METRICS)
public class ItemResource {

    @GET
    public Response getAllItems() {
        List<Item> items = Database.getItems();
        return Response.ok(items).build();
    }


    @GET
    @Path("{id}")
    public Response getItem(@PathParam("id") String id) {

        Item item = Database.getItem(id);
        return item != null
                ? Response.ok(item).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }



    @POST
    public Response addItem(Item item) {
        Database.addItem(item);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteItem(@PathParam("id") String id) {
        Database.deleteItem(id);
        return Response.ok().build();
    }
}
