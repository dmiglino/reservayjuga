<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />

    <link href="/ReservaYJuga/kendo/styles/kendo.common.min.css" rel="stylesheet" />
    <link href="/ReservaYJuga/kendo/styles/kendo.default.min.css" rel="stylesheet" />
    <script src="/ReservaYJuga/kendo/js/jquery.min.js"></script>
    <script src="/ReservaYJuga/kendo/js/kendo.all.min.js"></script>
    <title><g:message code="sistema.principal.titulo.label" default="Pagina Principal del Sistema" /></title>
</head>
<body>
    <div id="example" class="k-content">
    <div id="scheduler"></div>
    <div id="test"></div>
</div>

<script>

<%--<g:remoteFunction controller="PanelControl" action="getResources" update="test"/>--%>

var sharableDataSource = new kendo.data.DataSource({
    transport: {
        read: {
            url: "http://localhost:8080/ReservaYJuga/panelControl/getResources",
            dataType: "json"
        }
    }
});

$(function() {
    $("#scheduler").kendoScheduler({
        date: new Date("2013/6/13"),
        startTime: new Date("2013/6/13 07:00 AM"),
        height: 600,
        views: [
            { type: "day", selected: true },
            "week",
            "month"
        ],
        timezone: "Etc/UTC",
        dataSource: {
            batch: true,
            transport: {
                read: {
                    url: "http://demos.kendoui.com/service/meetings",
                    dataType: "jsonp"
                },
                update: {
                    url: "http://demos.kendoui.com/service/meetings/update",
                    dataType: "jsonp"
                },
                create: {
                    url: "http://demos.kendoui.com/service/meetings/create",
                    dataType: "jsonp"
                },
                destroy: {
                    url: "http://demos.kendoui.com/service/meetings/destroy",
                    dataType: "jsonp"
                },
                parameterMap: function(options, operation) {
                    if (operation !== "read" && options.models) {
                        return {models: kendo.stringify(options.models)};
                    }
                }
            },
            schema: {
                model: {
                    id: "meetingID",
                    fields: {
                        meetingID: { from: "MeetingID", type: "number" },
                        title: { from: "Title", defaultValue: "No title", validation: { required: true } },
                        start: { type: "date", from: "Start" },
                        end: { type: "date", from: "End" },
                        startTimezone: { from: "StartTimezone" },
                        endTimezone: { from: "EndTimezone" },
                        description: { from: "Description" },
                        recurrenceId: { from: "RecurrenceID" },
                        recurrenceRule: { from: "RecurrenceRule" },
                        recurrenceException: { from: "RecurrenceException" },
                        roomId: { from: "RoomID", nullable: true },
                        atendees: { from: "Atendees", nullable: true },
                        isAllDay: { type: "boolean", from: "IsAllDay" }
                    }
                }
            }
        },
        group: {
            resources: ["Rooms"]
        },
        resources: [
            {
                field: "roomId",
                name: "Rooms",
                dataSource: sharableDataSource,
                title: "Room"
                

            }
            
        ]
    });
});
</script>


</body>
</html>