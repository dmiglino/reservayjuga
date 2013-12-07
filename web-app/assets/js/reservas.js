document._shcar = {};
document._dayslimit = 90;
function _step(n, reset) {
    switch(parseInt(n)) {
        case 2: 
            if('' == $('_club').value) 
                return false;
        break;
        case 3: 
            if('' == $('_res_date').value || '' == $('_res_time').value || '' == $('_court').value) 
                return false;

            fillstep3();
        break;
        case 4:
            if('' == $('_club').value || '' == $('_res_date').value || '' == $('_res_time').value || '' == $('_court').value) 
                return false;
        break;
        default:;
    }
    $$('ul.steps_lease li').each(function(s) { s.removeClassName('active'); });

    for(i=0;i<n;++i)
        $$('.steps_lease li')[i].addClassName('active');
 
    $('w').show();
    $$('.Wstep').each(function(e) {
        e.hide();
    });

    $('_Wstep'+n).show();
    try {$('nextstep'+n).show(); } catch(e) {}
    return false;
}
function fillstep3() {                   
    var club = $('_club').value;
    if('' == club || undefined == club)
        return false;

    var data = {_action:'prices5',_club:club};
    var __b = function() {};
    var __a = function(json) {
        if(json == undefined) {
            feedback('ERROR DE CONEXION', 2);
            return false;
        }
        if(json.res != 0) {
            feedback(json.msg, 2);
            return false;
        }
        $('step3dress').update('<strong> $'+json.dress+'</strong>');
        $('chk_dress').title = json.dress.replace('.','');
        $('step3referee').update('<strong> $'+json.referee+'</strong>');
        $('chk_referee').title = json.referee.replace('.','');
        $('step3ball').update('<strong> $'+json.ball+'</strong>');
        $('chk_ball').title = json.ball.replace('.','');
        return false;
    };

    return __request('process.php', data, __b, __a);
}
function allowPayOptions(club) {
    var data = {_action:'clubs5',_id:club};
    var __b = function() {};
    var __a = function(json) {
        if(json == undefined) return false;
        if(json.res != 0) return false;

        var bt = $('bt_pay');
        if(json.allow)
            bt.onclick = function onclick(event) { pay_step2(); };
        else
            bt.onclick = function onclick(event) { __pay(document.id_session); };

        return;
    };

    return __request('process.php', data, __b, __a);
}
function _step1a(el, id) {
    $('selecttime').update('<center>Seleccione un día, para ver los horarios</center>');
    $('selectcourt').update('');
    $('st_time').update('');
    $('_res_time').value = '';
    $('st_court').update('');
    $('_court').value = '';

    updateTotals(0);
    allowPayOptions(id);

    //check promo
    document.pobj['_club'] = id;

    $('st_name').update(el.title);
    $('_club').value = id;
    $('tb_club').update(el.title);
    _step(2);
    return true;
}
//select date
function _step2a(d) {
    var club = $('_club').value;
    if('' == club)
        return false;

    var parts = d.split(/-/);
    var today = document.today.split(/-/);

    var _date = new Date(parts[0],parts[1]-1,parts[2]);
    var _today = new Date(today[2],today[1]-1,today[0]);
    var _datelimit = new Date();

    _datelimit.setDate(_today.getDate()+document._dayslimit);

    if(_date.getTime() < _today.getTime()) {
        $('selecttime').update('<center>Seleccione una fecha v&aacute;lida</center>');
        return;
    }

    if(_date.getTime() >= _datelimit.getTime()) {
        $('selecttime').update('<center><img src="../img/loader.gif"></center>');
        setTimeout(function() { $('selecttime').update('<center>Seleccione una fecha inferior a ' + document._dayslimit + ' d&iacute;as</center>'); }, '500');
        return;
    }

    if(_date <= _today) {
        $('invaliddelta').show();
        $('validdelta').hide();
    }
    else {
        $('validdelta').show();
        $('invaliddelta').hide();
    }

    var Y = _date.getFullYear();
    var M = _date.getMonth() + 1;
    var Dy = _date.getDate();
    var sd = Dy + '-' + M + '-' + Y;

    //set 
    $('st_date').update(sd);
    $('_res_date').value = sd;
    $('tb_date').update(sd);
    $('st_time').update('');
    $('_res_time').value = '';
    $('st_court').update('');
    $('_court').value = '';
    $('tb_courtp').update('');

    //check promo
    document.pobj['_date'] = sd;

    updateTotals(0);

    $('selectcourt').update('');
    $('selecttime').update('<center><img src="../img/loader.gif"></center>');
    $('selectcourt').update('<center>Seleccione una hora para ver las canchas</center>');
    new Ajax.Updater('selecttime', '_timeSelect.php', {
        parameters: { _date: d, _club: club }
    });
    return true;
}
//select time
function _step2b(el,t) {
    if('' == $('_res_date').value) { 
        feedback('Seleccione una fecha', 3);
        return false;
    }
    var r = t.split(' - ');
    $('st_time').update(t);
    $('_res_time').value = r[0];
    $('tb_time').update(t);
    $('st_court').update('');
    $('_court').value = '';

    //check promo
    document.pobj['_time'] = r[0];

    updateTotals(0);

    document.total = 0;

    $('selectcourt').update('<center><img src="../img/loader.gif"></center>');
    new Ajax.Updater('selectcourt', '_courtSelect.php', {
        parameters: { _club: $('_club').value, _date: $('_res_date').value, _time: r[0] }
    });

    $$('.timeli').each(function(e) {
        e.removeClassName('active');
    });

    el.addClassName('active');
    return true;
}
function _step2c(el) {
    if('' == $('_res_date').value) { 
        feedback('Seleccione una fecha', 3);
        return false;
    }
   
    var o = el.id.split('-');

    var res_date = $('_res_date').value;
    var res_time = $('_res_time').value;
    var client = $('_client').value;

    document.total = o[1];
    $('st_court').update(o[4]);
    $('_court').value = o[0];
    $('tb_court').update(el.title);
    $('tb_courtp').update(o[1]);

    //check promo
    document.pobj['_court'] = o[0];

    clearExtras();
    updateTotals(o[1]);

    $$('.courtli').each(function(e) {
        e.removeClassName('active');
    });

    el.addClassName('active');
    return true;
}
function clearExtras() {
    $$('input[type="checkbox"]').each(function(e) { e.checked = false; });
    $$('.checkbox').each(function(e) {e.removeClassName('check')});
    $$('.nvc').each(function(e) {e.value = 0});
    $('tb_ball').update(0);
    $('tb_del_ball').update(new Element('span', {className:'del',style: 'opacity:.5'}).update('Borrar'));
    $('tb_dress').update(0);
    $('tb_del_dress').update(new Element('span', {className:'del',style: 'opacity:.5'}).update('Borrar'));
    $('tb_referee').update(0);
    $('tb_del_referee').update(new Element('span', {className:'del',style: 'opacity:.5'}).update('Borrar'));
}
function deleteItem(el) {
    el.checked = false;
    updateTotal(el);
}
function updateTotal(el) {
    var id = el.id.replace('chk', '');
    if(el.checked) {
        document.extras = parseInt(document.extras) + parseInt(el.title);
        document.total = parseInt(document.total) + parseInt(el.title);
        $(id).value = parseInt(el.title);
        $('tb'+id).update(parseInt(el.title));
        $('tb_del'+id).update(new Element('a', { className:'del',href:'javascript:;',onclick:'deleteItem($("chk'+id+'"))'}).update('Borrar'));
    }
    else {
        document.extras = parseInt(document.extras) - parseInt(el.title);
        document.total = parseInt(document.total) - parseInt(el.title);
        $(id).value = 0;
        $('tb'+id).update(0);
        $('tb_del'+id).update(new Element('span', { className:'del',style: 'opacity:.5'}).update('Borrar'));
    }

    updateTotals(document.total);

    return false;
}
function _clearform() {
    $$('.w__w').each(function(e) { e.value = ''; });
    $$('.w__o').each(function(e) { e.update(''); });
    $('st_date').update(document.today);
    $('_res_date').value = document.today;
    $$('input[type="radio"]').each(function(e) { e.checked = false; });
    $$('input[type="checkbox"]').each(function(e) { e.checked = false; });
    updateTotals(0);
    return false;
}
function _reserve(el) {
    var after = function(js) {
        var siz = js.elements.size();
        var tbl = $('res_summary_body');
        var obj = js.elements[0];
        var hdr = Array('club', 'res_date', 'res_time', 'court', 'courtp', 'extras', 'total','expire');
        var hdrsiz = hdr.size();
        var row = tbl.insertRow(0);
        row.id = 'res_row-'+obj.id;
        for(var j=0; j<hdrsiz; ++j) {
            var rowdiv = new Element('div');
            if('total' == hdr[j] || 'extras' == hdr[j] || 'courtp' == hdr[j]) 
                rowdiv.update('$ ' + obj[ hdr[j] ] + '.-');
            else
                rowdiv.update(obj[ hdr[j] ]);
            var celln = row.insertCell(j);
            if('expire' == hdr[j]) {
                celln.title = 'Quedan ' + obj[ hdr[j] ] + ' para realizar transferencia';
                celln.id = 'timeleft-'+obj.id;
            }
            celln.appendChild(rowdiv);
        }
        var celln = row.insertCell(j);
        celln.id = 'actions-'+obj.id;
        var rowedit = new Element('a', { className:'deleteField del',href:'javascript:;',onclick:'_deleteres('+js.elements[0].id+')' }).update('Borrar'); 
        celln.update(rowedit);
        $('dvtotal').update('$ ' + addCommas(parseInt($('dvtotal').title) + parseInt(obj[ 'total' ].replace('.',''))) + '.-');
        $('dvtotal').title = parseInt($('dvtotal').title) + parseInt(obj[ 'total' ].replace('.',''));

        $('w').hide();
        $('_Wtable').show();
        _clearform();
    };
    return __save(el, after);
}
function _deleteres(id) {
    if(!confirm('¿Seguro desea eliminar esta reserva?'))
        return false;

    var data = {_action:'res_queues3',_id:id};
    var __b = function() {};
    var __a = function(json) {
        if(json == undefined) {
            feedback('ERROR DE CONEXION', 2);
            return false;
        }
        if(json.res != 0) {
            feedback(json.msg, 2);
            return false;
        }

        var rup = $('res_row-'+id).up();
        $('dvtotal').update('$ ' + addCommas(parseInt($('dvtotal').title) - parseInt(json.p)) + '.-');
        $('dvtotal').title = parseInt($('dvtotal').title) - parseInt(json.p);
        $('res_row-'+id).remove();

        if(rup.rows.length == 0) {
            _step(1);
            $('_Wtable').hide();
        }
        feedback(json.msg);
        return false;
    };

    return __request('process.php', data, __b, __a);
}
function _clearcurrent() {
    _clearform();
    _step(1);
}
function __register(_form) {   
    if(!checkrequired(_form.id))
        return false;
        
    var data = _form.serialize(true); 
    var __b = function(){ __workingBT(_form.id); };
    var __a = function(json) {
        if(json == undefined) { feedback('ERROR DE CONEXI&Oacute;N', 2); __workingBT(_form.id, true); return false; }
        if(json.res != 0) {
            if(undefined != json.cmp) {
                json.cmp.each(function(e) {
                    $(e).addClassName('missing');
                });
            }       
            feedback(json.msg, 2);
            __workingBT(_form.id, true);
            return false;
        };
        __workingBT(_form.id, true);
        $('_client').value = json.id;
        $('login_holder').remove();
        $('register_holder').remove();
        $('info_name').update(json.name);
        $('info_mail').update(json.mail);
        $('info_actions').update(new Element('a', { href:'profile.php' }).update('Perfil'))
                           .insert(new Element('a', { href:'process.php?_toreserva=1&_id='+json.id+'&_action=users11' }).update('Salir'));
        $('nologin').insert({ after: new Element('button', {className:'button button_green',onclick:'_showPayScreen()'}).update('Pagar') });
        $('nologin').remove();
        _gaq.push(['_trackEvent', 'ArriendoFutbolito2014', 'Registro', 'Website']);
    };
    return __request('process.php', data, __b, __a);
}
function __login(_form) {
    if(!checkrequired(_form.id))
        return false;

    var data = _form.serialize(true);
    var __b = function(){ __workingBT(_form.id); };
    var __a = function(json) {
        if(json == undefined) { feedback('ERROR DE CONEXI&Oacute;N', 2); __workingBT(_form.id, true); return false; }
        if(json.res != 0) {
            if(undefined != json.cmp) {
                json.cmp.each(function(e) {
                    $(e).addClassName('missing');
                });
            }
            feedback(json.msg, 2);
            $$('input[type="password"]').each(function(e) { e.value = ''; });
            __workingBT(_form.id, true);
            return false;
        };
        __workingBT(_form.id, true);

        //login success
        $('_client').value = json.id;
        $('login_holder').remove();
        $('info_name').update(json.name);
        $('info_mail').update(json.mail);
        $('info_actions').update(new Element('a', { href:'profile.php' }).update('Perfil'))
                           .insert(new Element('a', { href:'process.php?_toreserva=1&_id='+json.id+'&_action=users11' }).update('Salir'));
        $('nologin').insert({ after: new Element('button', {className:'button button_green',onclick:'_showPayScreen()'}).update('Pagar') });
        $('nologin').remove();
        _gaq.push(['_trackEvent', 'ArriendoFutbolito2014', 'Entrar', 'Website']);
    };
    return __request('process.php', data, __b, __a);
}
function _showLoginForm() {
    $('register_holder').hide();
    $('login_holder').show();
}
function _showRegisterForm() {
    $('login_holder').hide();
    $('register_holder').show();
}
function _showPayScreen() {
    var data = $('frm-reserve').serialize(true);
    if(data._total == 0)
        return false;

    //prepare pay modal
    preparePayScreen();

    //check court and lock
    lock(data);
}
function preparePayScreen() {
    /*display pay options*/
    var std_promo = $('std_at_promo');
    var webpay = $('at-webpay');
    var voucher = $('at-voucher');
    var check = $('at-check');

    $$('.bt-box').each(function(e) { e.hide(); });

    document.pobj['_action'] = 'PM_5';
    var __data = document.pobj;
    var __b = function() {};
    var __a = function(json) {
        if(json == undefined) 
            return false;
        if(json.res != 0) 
            return false;

        if(json.hasPromo) {
            if(null != std_promo && undefined != std_promo) {
                $('std_bt_promo').show();
                $('std_promo_pay').hide();
                $('std_promo_value').update(json.promotxt);
                std_promo.show();
            }
        }

        check.show();
        webpay.show();
        voucher.show();
        return false;
    };
    return __request('process.php', __data, __b, __a);
}
function lock(data) {
    var __data = {_action:'courts8',_court:data._court,_locker:data._client,_lock_date:data._res_date,_lock_time:data._res_time}
    var __b = function() {};
    var __a = function(json) {
        if(json == undefined) {
            feedback('ERROR DE CONEXI&Oacute;N', 2);
            return false;
        }
        if(json.res != 0) {
            feedback(json.msg, 2);
            return false;
        }
        $$('.bomb').each(function(e) { if(e.hasClassName('hideme')) e.hide(); if(e.hasClassName('uncheckme')) e.checked = false; });
        $('pay_step2').hide();
        $('pay_step1').show();
        $('pay_options').show();
        return false;
    };
    return __request('process.php', __data, __b, __a);
}
function __closePaymodal() {
    var data = $('frm-reserve').serialize(true);
    
    var __b = function() {};
    var __a = function(json) {
        if(json == undefined) {
            feedback('ERROR DE CONEXI&Oacute;N', 2);
            return false;
        }
        if(json.res != 0) {
            feedback(json.msg, 2);
            return false;
        }
        $$('.genmodal').each(function(e){ e.hide(); });
        return false;
    };
    return __request('process.php', {_action:'courts6',_court:data._court,_locker:data._client,_lock_date:data._res_date,_lock_time:data._res_time}, __b, __a);
}
function __closeLRmodal() {
    $$('.genmodal').each(function(e){ e.hide(); });
}
function __showVoucherPay() {
    if(!$('tos_accept').checked) {
        new Effect.Highlight($('tos_txt'), { afterFinish: function(e) { e.element.style.backgroundColor = ''; }, startcolor: "#FFD700", duration:3 });
        return false;
    }

    $$('.vp').each(function(e){ e.value = ''; });
    $('voucherPay').toggle();
}
function toNextField(field, nextField) {
    var f = field.value;

    if(field.id == 'vc1') {
        var buf = String(f);
        var _ok = false;
       
        if(buf.match(/^(?:[0-9A-Fa-f]{8}\-){4}[0-9A-Fa-f]{8}$/))
            _ok = true;
        else
            if(buf.match(/^[0-9A-Fa-f]{40}$/)) {
                buf = buf.replace(/([0-9a-f]{8}(?=[0-9a-f]))/gi, '$1-'); 
                _ok = true;
        }
        if(_ok) {
            var vValues = buf.split(/-/);
            for(var k=0;k<5;++k) {
                $('vc'+(k+1)).value =  vValues[k];  
            }

            $('voucherbsubmit').focus();
            return false;
        }
    }
    if(f.length < 8)
        return false;
    else  {
        if(f.length == 8 ) {
            nextField.focus();
            return false;
        }

        field.value =  String(field.value).substring(0, 7); 
        for(var k=1;k<5;++k) {
            $('vc'+(k+1)).value =  '';  
        }
    }
    return false;
}
function __usevpay() {
    var extras = false;
    var data = $('frm-reserve').serialize(true);
    data._vc = '';
    data._action = 'rp6';
    for(i=1;i<=5;++i) {
        if('' == $('vc'+i).value || $('vc'+i).value.length < 8) {
            $('vc'+i).focus();
            return false;
        }
        data._vc += $('vc'+i).value;
    }

    $$('.nvc').each(function(e) {
        if(e.value != 0) {
            extras = true;
            return;
        }
    });

    //si eligio elementos extras alertar
    if(extras) {
        feedback('Los Voucher solo son v&aacute;lidos para arriendo de canchas.<br>Por favor elimine los items extras y vuelva a intentarlo.',3);
        return false;
    }

    var __b = function() { __workingBT('frm-vpay'); };
    var __a = function(json) {
        if(json == undefined) {
            __workingBT('frm-vpay', true);
            feedback('ERROR DE CONEXI&Oacute;N', 2);
            return false;
        }
        if(json.res != 0) {
            __workingBT('frm-vpay', true);
            feedback(json.msg, 2);
            return false;
        }
        __workingBT('frm-vpay', true);
        feedback(json.msg);
        __closeLRmodal();
        var o = json.e[0];

        var url = 'vcsuccess.php?TBK_ORDEN_COMPRA='+o.oc;
        
        window.location = url;
        return false;
    };
    return __request('process.php', data, __b, __a); 
}
function finalize() {
    $('_CVtable').hide();
    _clearcurrent();
    $$('.ns').each(function(e) { e.show(); });
}
function __pay(sid) {
    if(!$('tos_accept').checked) {
        new Effect.Highlight($('tos_txt'), { afterFinish: function(e) { e.element.style.backgroundColor = ''; }, startcolor: "#FFD700", duration:3 });
        return false;
    }

    var data = $('frm-reserve').serialize(true);
    data._action = 'rp7';
    data._id_session = sid;
    var __b = function() {
        _gaq.push(['_trackEvent', 'ArriendoFutbolito2014', 'Compra', 'Website', parseInt(data._total)]);
    };
    var __a = function(json) {
        if(json == undefined) {
            feedback('ERROR DE CONEXI&Oacute;N', 2);
            return false;
        }
        if(json.res != 0) {
            feedback(json.msg, 2);
            return false;
        }

        $('TBK_ORDEN_COMPRA').value = json.oc;
        $('webpay_form').submit();

        return false;
    };
    return __request('process.php', data, __b, __a);
}
function pay_step3() {
    alert('ohhh');
}

function pay_step2() {
    if(!$('tos_accept').checked) {
        new Effect.Highlight($('tos_txt'), { afterFinish: function(e) { e.element.style.backgroundColor = ''; }, startcolor: "#FFD700", duration:3 });
        return false;
    }

    var data = $('frm-reserve').serialize(true);
    data._action = 'court_prices7';
    var __b = function() {};
    var __a = function(json) {
        if(json == undefined) {
            feedback('ERROR DE CONEXI&Oacute;N', 2);
            return false;
        }
        if(json.res != 0) {
            feedback(json.msg, 2);
            return false;
        }

        var total = json.price;
        var p75 = total*.75;
        var p50 = total*.5;
        var p25 = total*.25;
        var pmin = total*.15;
        var tpaid = $('tpaid');
        tpaid.update(new Element('option', {value:total}).update('Pagar el total $'+addCommas(total)+'.-'));

        var ops = json.ops[0];
        tpaid.update(new Element('option', {value:total}).update('Pagar el total $'+addCommas(total)+'.-'));
        if(ops.pay75)
            tpaid.insert(new Element('option', {value:p75}).update('Pagar 75% $'+addCommas(p75)+'.-'));
        if(ops.pay50)
            tpaid.insert(new Element('option', {value:p50}).update('Pagar 50% $'+addCommas(p50)+'.-'));
        if(ops.pay25)
            tpaid.insert(new Element('option', {value:p25}).update('Pagar 25% $'+addCommas(p25)+'.-'));

        $('pay_step1').hide();
        $('pay_step2').show();
        return false;
    };
    return __request('process.php', data, __b, __a);
}
function updateTotalPaid(val) {
    $('_total_paid').value = val;
    updateTBMonto4Pay(val);
    return;
}
function updateTotals(val) {
    $('_total').value = val;
    $('_total_paid').value = val;
    $('TBK_MONTO').value = val;
    $('st_total').update(addCommas(val)+'.-');
    $('tb_total').update(addCommas(val)+'.-')
}
function updateTBMonto4Pay(val) {
    $('TBK_MONTO').value = val;
}
function contact(){ 
    window.open('contact.php','ArriendoFutbolito.cl','width=570, height=670')
}
