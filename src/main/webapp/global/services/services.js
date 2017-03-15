(function(){
	'use strict';
	
	angular.module('mediaticApp.service')
	.service('ServiceUrl',function($http){
		
		var self = this;
		
		var rootUrl = "http://192.168.10.17:8090";
		
		var mediaRechercheUrl = rootUrl+"/resource/media.recherche";// GET page, titre, auteur,type,tri:(id,titre,auteur)
		var mediaCreationUrl = rootUrl+"/resource/media.creation";// POST
		var mediaModificationUrl = rootUrl+"/resource/media.modification";// GET
		var mediaAccessionUrl = rootUrl+"/resource/media.accession";// GET
		
		var adherentRechercheUrl = rootUrl+"/resource/adherent.recherche";// GET page,id,nom,prenom,email,texte nom prenom,tri : (id,nom,prenom,email,-id,-nom,-prenom,-email)
		var adherentCreationUrl = rootUrl+"/resource/adherent.creation";// POST
		var adherentModificationUrl = rootUrl+"/resource/adherent.modification";// GET
		var adherentAccessionUrl = rootUrl+"/resource/adherent.accession";// GET
		
		var ajoutEmrpuntUrl = rootUrl+"/resource/emprunt.ajout";// POST id_adherent,id_media, depart	
		
		this.getPromise = function(url){
			 return $http.get(url).then(function(response){
				return response.data;
			},function(){
				console.log('Flûte alors... plus d\'internet mondiale :/');
			});
		}
		
		this.getMedias = function(){
			return self.getPromise(mediaRechercheUrl);
		}
		
		this.getMediaById = function(id){
			return self.getPromise(mediaAccessionUrl+"?id="+id);
		}
		
		this.addMedia = function(newMedia){
			$http.post(mediaCreationUrl,newMedia);
		}
		
		this.updateMedia = function(media){
			$http.post(mediaModificationUrl,media);
		}
		
		this.getMediasByParams = function(params){
			var paramsPresents = [];
			if(params.page != undefined)
			{
				paramsPresents.push({label : "page", param : params.page});
			}
			if(params.titre != undefined)
			{
				paramsPresents.push({label : "titre", param : params.titre});
			}
			if(params.auteur != undefined)
			{
				paramsPresents.push({label : "auteur", param : params.auteur});
			}
			if(params.type != undefined)
			{
				paramsPresents.push({label : "type", param : params.type});
			}
			if(paramsPresents.length == 0)
			{
				return self.getMedias();
			}
			else
			{
				var paramsUrl = "?";
				for(var index in paramsPresents)
				{
					paramsUrl += paramsPresents[index].label + "=" + paramsPresents[index].param +"&";
				}
				console.log(mediaRechercheUrl+paramsUrl);
				return self.getPromise(mediaRechercheUrl+paramsUrl);
			}
		}
		
		this.getAdherents = function(){
			return self.getPromise(adherentRechercheUrl);
		}
		
		this.getAdherentById = function(id){
			return self.getPromise(adherentAccessionUrl+"?id="+id);
		}
		
		this.addAdherent = function(newAdherent){
			$http.post(adherentCreationUrl,newAdherent);
		}
		
		this.updateAdherent = function(adherent){
			$http.post(adherentModificationUrl,adherent);
		}
		
		this.getAdherentsByParams = function(params){
			var paramsPresents = [];
			if(params.page != undefined)
			{
				paramsPresents.push({label : "page", param : params.page});
			}
			if(params.id != undefined)
			{
				paramsPresents.push({label : "id", param : params.id});
			}
			if(params.nom != undefined)
			{
				paramsPresents.push({label : "nom", param : params.nom});
			}
			if(params.prenom != undefined)
			{
				paramsPresents.push({label : "prenom", param : params.prenom});
			}
			if(params.email != undefined)
			{
				paramsPresents.push({label : "email", param : params.email});
			}
			if(params.texte != undefined)
			{
				paramsPresents.push({label : "texte", param : params.texte});
			}
			if(paramsPresents.length == 0)
			{
				return self.getAdherents();
			}
			else
			{
				var paramsUrl = "?";
				for(var index in paramsPresents)
				{
					paramsUrl += paramsPresents[index].label + "=" + paramsPresents[index].param +"&";
				}
				console.log(adherentRechercheUrl+paramsUrl);
				return self.getPromise(adherentRechercheUrl+paramsUrl);
			}
		}
		
		this.addEmpruntMedia = function(idAdherent, idMedia, dateDepart){
			$http.post(ajoutEmrpuntUrl,{id_adherent:idAdherent,id_media:idMedia,depart:dateDepart});
		}
		
		this.getConnection = function(){
			return rootUrl+'/resource/connexion.rights';
		}
			
	});
	
})();
