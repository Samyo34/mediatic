(function(){
	'use strict';
	
	angular.module('mediaticApp.service')
	.service('ServiceUrl',function($http){
		
		var self = this;
		
		var rootUrl = "http://localhost:8080/mediatic";
		
		var mediaRechercheUrl = rootUrl+"/ws/resource/media/recherche";// GET page, titre, auteur,type,tri:(id,titre,auteur)
		var mediaCreationUrl = rootUrl+"/ws/resource/media/creation";// POST
		var mediaModificationUrl = rootUrl+"/ws/resource/media/modification";// GET
		
		var adherentRechercheUrl = rootUrl+"/ws/resource/adherent/recherche";// GET page,id,nom,prenom,email,texte nom prenom,tri : (id,nom,prenom,email,-id,-nom,-prenom,-email)
		var adherentCreationUrl = rootUrl+"/ws/resource/adherent/creation";// POST
		var adherentModificationUrl = rootUrl+"/ws/resource/adherent/modification";// GET
		
		var ajoutEmrpuntUrl = rootUrl+"/ws/resource/emprunt/ajout";// POST id_adherent,id_media, depart	
		
		this.getPromise = function(url){
			 return $http.get(url).then(function(response){
				return response.data;
			},function(){
				console.log('Flûte alors... plus d\'internet mondiale :/');
			});
		}
		
		this.getPromiseWithParams = function(url,params){
			 return $http.get(url,{ "params" : params}).then(function(response){
				return response.data;
			},function(){
				console.log('Flûte alors... plus d\'internet mondiale :/');
			});
		}
		
		this.getMedias = function(){
			console.log(mediaRechercheUrl);
			return self.getPromise(mediaRechercheUrl);
		}
		
		this.getMediaById = function(id){
			return self.getPromise(mediaRechercheUrl+"/"+id);
		}
		
		this.addMedia = function(newMedia){
			return $http.post(mediaCreationUrl,newMedia);
		}
		
		this.updateMedia = function(media){
			$http.post(mediaModificationUrl,media);
		}
		
		this.getMediasByParams = function(params){
			return self.getPromiseWithParams(mediaRechercheUrl,params);
		}
		
		this.getAdherents = function(){
			console.log(adherentRechercheUrl);
			return self.getPromise(adherentRechercheUrl);
		}
		
		this.getAdherentById = function(id){
			return self.getPromise(adherentRechercheUrl+"/"+id);
		}
		
		this.addAdherent = function(newAdherent){
			return $http.post(adherentCreationUrl,newAdherent);
		}
		
		this.updateAdherent = function(adherent){
			$http.post(adherentModificationUrl,adherent);
		}
		
		this.getAdherentsByParams = function(params){
			return self.getPromiseWithParams(adherentRechercheUrl,params);
		}
		
		this.addEmpruntMedia = function(idAdherent, idMedia, dateDepart){
			console.log(idAdherent);
			$http.post(ajoutEmrpuntUrl,{id_adherent:idAdherent,id_media:idMedia,depart:dateDepart});
		}
		
		this.getConnection = function(){
			return rootUrl+'/resource/connexion.rights';
		}
			
	});
	
})();
