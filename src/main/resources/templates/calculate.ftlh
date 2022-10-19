<#import "common/common.ftlh" as common>

<@common.page>
    <div style="padding: 10px">
        <form method="post" action="/calculate">
            <p>Выберите дату начала отпуска: <label>
                    <input type="date" name="calendar1">
                </label></p>
            <p>Выберите дату окончания отпуска: <label>
                    <input type="date" name="calendar2">
                </label></p>
            <p>Укажите размер своей заработной платы: <label>
                    <input type="number" name="salary">
                </label></p>
            <button type="submit">Высчитать отпускные</button>
            <div>
                <span style="font-size: large; color: #b22222; font-family: serif; "><#if isNotTry??>${isNotTry}</#if></span>
            </div>
        </form>

    </div>
</@common.page>

